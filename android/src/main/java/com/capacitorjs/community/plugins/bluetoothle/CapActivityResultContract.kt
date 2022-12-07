package com.capacitorjs.community.plugins.bluetoothle

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract

import com.getcapacitor.PluginCall

class CapActivityResultContract : ActivityResultContract<CapStartActivityParam, CapActivityResult>() {

    var jsCall: PluginCall? = null

    override fun createIntent(context: Context, param: CapStartActivityParam): Intent {
        jsCall = param.call
        return param.intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): CapActivityResult {
        return CapActivityResult(jsCall!!, ActivityResult(resultCode, intent))
    }
}