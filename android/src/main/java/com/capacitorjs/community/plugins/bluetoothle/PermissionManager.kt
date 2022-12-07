package com.capacitorjs.community.plugins.bluetoothle

import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import com.getcapacitor.Bridge
import com.getcapacitor.PluginCall
import com.getcapacitor.JSObject

class PermissionManager(private val bridge: Bridge) {

    fun permissionAliases(call: PluginCall): Array<String> {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val neverForLocation = call.getBoolean("androidNeverForLocation", false) as Boolean

            return if (neverForLocation) {
                arrayOf(
                    BLUETOOTH_SCAN_ALIAS,
                    BLUETOOTH_CONNECT_ALIAS,
                )
            } else {
                arrayOf(
                    BLUETOOTH_SCAN_ALIAS,
                    BLUETOOTH_CONNECT_ALIAS,
                    ACCESS_FINE_LOCATION_ALIAS,
                )
            }
        }
        return arrayOf(
            ACCESS_FINE_LOCATION_ALIAS,
        )
    }

    fun hasBluetoothScanPermission(): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            return true
        }

        return this.hasPermission(android.Manifest.permission.BLUETOOTH_SCAN)
    }

    fun hasBluetoothConnectPermission(): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            return true
        }

        return this.hasPermission(android.Manifest.permission.BLUETOOTH_CONNECT)
    }

    fun hasAccessFineLocationPermission(): Boolean {
        return this.hasPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
    }

    fun hasPermissions(): Boolean {
        return this.hasBluetoothScanPermission() && this.hasBluetoothConnectPermission() && this.hasAccessFineLocationPermission()
    }

    fun toPermissionObject(hasPerm: Boolean): JSObject {
        val result = JSObject()
        result.put("hasPermission", hasPerm)
        return result
    }

    fun toPermissionsObject(hasPerms: Boolean): JSObject {
        val result = JSObject()
        result.put("hasPermissions", hasPerms)
        return result
    }

    private fun hasPermission(permissionId: String): Boolean {
        val hasPerm = ContextCompat.checkSelfPermission(this.bridge.getContext(), permissionId)
        return hasPerm == PackageManager.PERMISSION_GRANTED
    }

    companion object {
        const val BLUETOOTH_SCAN_ALIAS = "bluetoothScan"
        const val BLUETOOTH_CONNECT_ALIAS = "bluetoothConnect"
        const val ACCESS_FINE_LOCATION_ALIAS = "accessFineLocation"
    }
}