package com.example.coroutinekotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //give types of thread in which dispatcher runs
        GlobalScope.launch(Dispatchers.IO) {
            //do task
        }
        //for creating our own  thread
        GlobalScope.launch(newSingleThreadContext("MyThread")) {
            //do task
        }
        // for creating newteok call using IO Thread and updating UI with chnaging the context of thread UI
        GlobalScope.launch(Dispatchers.IO) {
            val networkCall = doNetworkCall()
            Log.d(TAG, "THread name in IO is  ${Thread.currentThread().name}")
            //now chnaging it to the Main thread
            withContext(Dispatchers.Main) {    // with context is use to chnage the thread context
                tvShowText.text = networkCall
                Log.d(TAG, "THread name in MAIN  is ${Thread.currentThread().name}")
            }
        }

    }
}

// Dispatcher has 4 Thread
//1. Main thread -> to update the UI
//2.IO thread -> to perfomr network call or database write read file
//3.default -> to perform large calculation and perform heavy task
//4. unconfined --> resume the suspedn thread

suspend fun doNetworkCall(): String {
    delay(3000L)
    return "This is the answer"
}
