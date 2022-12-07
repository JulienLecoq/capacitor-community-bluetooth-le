import Foundation
import CoreBluetooth
import Capacitor

enum Permission {
    enum State: String {
        case prompt = "prompt"
        case granted = "granted"
        case denied = "denied"
    }
    
    static func authorizationToStateString(_ authorization: CBManagerAuthorization) -> String {
        switch authorization {
        case .notDetermined:
            return Permission.State.prompt.rawValue
        case .restricted, .denied:
            return Permission.State.denied.rawValue
        case .allowedAlways:
            return Permission.State.granted.rawValue
        @unknown default:
            return Permission.State.denied.rawValue
        }
    }

    /**
     * Return true if the user has granted the bluetooth permission.
     */
    static func hasPermissions() -> Bool {
        return hasBluetoothPermission()
    }

    /**
     * Return the bluetooth permission status.
     */
    static func checkPermissions(_ deviceManager: DeviceManager?) -> [String: Permission.State.RawValue] {
        let status = checkBluetoothPermissionStateString(deviceManager)
        return [
            "accessFineLocation": status,
            "bluetoothScan": status,
            "bluetoothConnect": status,
        ]
    }
    
    static func hasBluetoothPermission() -> Bool {
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
    
    static func checkBluetoothPermissionStateString(_ deviceManager: DeviceManager?) -> String {
        if #available(iOS 13.1, *) {
            // iOS greather than 13.1
            return authorizationToStateString(CBCentralManager.authorization)
        } else if #available(iOS 13.0, *) {
            // iOS lower than 13.1"
            let manager = deviceManager?.centralManager ?? CBCentralManager(delegate: nil, queue: nil, options: ["CBCentralManagerOptionShowPowerAlertKey": false])
            return authorizationToStateString(manager.authorization)
        } else {
            // iOS lower than 13.0
            // Before iOS 13, Bluetooth permissions are not required
            return authorizationToStateString(CBManagerAuthorization.allowedAlways)
        }
    }
    
    static func checkBluetoothPermission(_ deviceManager: DeviceManager?) -> [String: Permission.State.RawValue] {
        return [
            "value": checkBluetoothPermissionStateString(deviceManager),
        ]
    }
}
