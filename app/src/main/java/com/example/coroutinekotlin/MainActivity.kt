package com.example.coroutinekotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
                val answer1 = async { networkingCall1() }
                val answer2 = async { networkingCall2() }
                Log.d(TAG, "Answer1 is ${answer1.await()}")
                Log.d(TAG, "Answer2 is ${answer2.await()}")
            }
            Log.d(TAG, "Request took is ${time}")
        }

    }

    suspend fun networkingCall1(): String {
        delay(3000L)
        return "First network call"
    }

    suspend fun networkingCall2(): String {
        delay(3000L)
        return "Second network call"
    }
}

