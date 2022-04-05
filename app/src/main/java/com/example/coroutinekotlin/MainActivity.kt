package com.example.coroutinekotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            val networkcallAnswer= doNetworkCall()
            val networkcallAnswer2= doNetworkCall2()
            Log.d(TAG,networkcallAnswer)
            Log.d(TAG,networkcallAnswer2)
        }
    }
}

suspend fun doNetworkCall(): String {
    delay(3000L)
    return "This is the answer"
}

suspend fun doNetworkCall2(): String {
    delay(3000L)
    return "This is the answer"
}