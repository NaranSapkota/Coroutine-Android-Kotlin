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
        val job=GlobalScope.launch(Dispatchers.Default) {
            Log.d(TAG,"Starting Long running calculation...")
            withTimeout(3000L)
            {
                for(i in 30..40){
                    if(isActive){
                        Log.d(TAG,"Result for i =${fib(i)}")
                    }
                }
            }
            Log.d(TAG,"Ending Long running calculation...")
        }
    }

    private fun fib(n: Int): Long {
        return if(n==0) 0
        else if(n==1) 1
        else fib(n-1)+ fib(n-2)
    }
}

