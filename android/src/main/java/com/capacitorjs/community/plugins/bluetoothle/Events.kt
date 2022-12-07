package com.capacitorjs.community.plugins.bluetoothle

enum class Events(private val value: String) {
    BLUETOOTH_STATE_CHANGE("bluetoothStateChange");

    fun value(): String {
        return value
    }
}