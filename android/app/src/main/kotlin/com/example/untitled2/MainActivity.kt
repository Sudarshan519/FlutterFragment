package com.example.untitled2

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterFragmentActivity() {
    private lateinit var result: MethodChannel.Result
    private val CHANNEL = "com.startActivity/testChannel"
        override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
            GeneratedPluginRegistrant.registerWith(flutterEngine)
            setMethodChannel()
        }

        private fun setMethodChannel() {

            MethodChannel(flutterEngine?.dartExecutor?.binaryMessenger!!,CHANNEL).setMethodCallHandler{
                    call, result ->
                    this.result = result
                if(call.method.equals("StartSecondActivity")){
                    val intent= Intent(this,MainActivity2::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    startActivityForResult(intent,22)
                }
                else{
                    result.notImplemented()
                }
            }
        }


override fun onActivityResult(requestCode: kotlin.Int, resultCode: kotlin.Int, data: android.content.Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
}
}
