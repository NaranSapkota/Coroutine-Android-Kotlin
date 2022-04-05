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
        Log.d(TAG,"Before the satrting of the run blocking ")
        runBlocking {
          Log.d(TAG,"After  the satrting of the run blocking ")

            launch(Dispatchers.IO){
                delay(3000L)
                Log.d(TAG,"Finsihed  IO courtine 1")
            }

            launch(Dispatchers.IO){
                delay(3000L)
                Log.d(TAG,"Finsihed  IO courtine 2")
            }
        }
        Log.d(TAG,"Finsihed  the satrting of the run blocking ")
    }

    // runBlocking is similar to the THread ..It block UI thread nut dispatcher doest block main thread
    //  launch runs idependently to the runBlocking
}

