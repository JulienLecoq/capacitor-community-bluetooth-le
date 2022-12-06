import Foundation
import CoreBluetooth
import Capacitor

enum Permission {
    enum State: String {
        case prompt = "prompt"
        case granted = "granted"
        case denied = "denied"
    }
    
    static func managerAuthorizationToJsonStatus(_ authorization: CBManagerAuthorization) -> [String: Permission.State.RawValue] {
        var status = Permission.State.denied.rawValue
        
        switch authorization {
        case .notDetermined:
            status = Permission.State.prompt.rawValue
        case .restricted, .denied:
            status = Permission.State.denied.rawValue
        case .allowedAlways:
            status = Permission.State.granted.rawValue
        @unknown default:
            status = Permission.State.denied.rawValue
        }
        
        return [
            "bluetoothScan": status,
            "bluetoothConnect": status,
        ]
    }
    
    /**
     * Return true if the user has granted the bluetooth permission.
     */
    static func hasPermissions() -> Bool {
        if #available(iOS 13.1, *) {
            // iOS greather than 13.1
            return CBCentralManager.authorization == .allowedAlways
        } else if #available(iOS 13.0, *) {
            // iOS lower than 13.1"
            return CBCentralManager(delegate: nil, queue: nil, options: ["CBCentralManagerOptionShowPowerAlertKey": false]).authorization == .allowedAlways
        }
        
        // iOS lower than 13.0
        // Before iOS 13, Bluetooth permissions are not required
        return true
    }

    /**
     * Return the bluetooth permission status.
     */
    static func checkPermissions(_ deviceManager: DeviceManager?) -> [String: Permission.State.RawValue] {
        var status: [String: Permission.State.RawValue]
        
        if #available(iOS 13.1, *) {
            // iOS greather than 13.1
            status = managerAuthorizationToJsonStatus(CBCentralManager.authorization)
        } else
        if #available(iOS 13.0, *) {
            // iOS lower than 13.1"
            let manager = deviceManager?.centralManager ?? CBCentralManager(delegate: nil, queue: nil, options: ["CBCentralManagerOptionShowPowerAlertKey": false])
            status = managerAuthorizationToJsonStatus(manager.authorization)
        } else {
            // iOS lower than 13.0
            // Before iOS 13, Bluetooth permissions are not required
            status = managerAuthorizationToJsonStatus(CBManagerAuthorization.allowedAlways)
        }
        
        return status
    }
}
