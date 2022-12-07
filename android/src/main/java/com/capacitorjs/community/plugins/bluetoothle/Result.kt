package com.capacitorjs.community.plugins.bluetoothle

import com.getcapacitor.JSObject

fun toValueResult(value: Any): JSObject {
    val result = JSObject()
    result.put("value", value)
    return result
}