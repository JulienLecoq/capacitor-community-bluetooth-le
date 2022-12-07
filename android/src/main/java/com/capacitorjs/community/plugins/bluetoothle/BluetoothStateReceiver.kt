package com.capacitorjs.community.plugins.bluetoothle

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

import com.getcapacitor.JSObject

class BluetoothStateReceiver(private val plugin: BluetoothLe) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (BluetoothAdapter.ACTION_STATE_CHANGED == action) {
            val state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1)
            val response = JSObject()
            when (state) {
                BluetoothAdapter.STATE_OFF -> {
                    response.put("isActive", false)
                    this.plugin.publicNotifyListeners(Events.BLUETOOTH_STATE_CHANGE.value(), response)
                }
                BluetoothAdapter.STATE_ON -> {
                    response.put("isActive", true)
                    this.plugin.publicNotifyListeners(Events.BLUETOOTH_STATE_CHANGE.value(), response)
                }
                else -> {}
            }
        }
    }
}