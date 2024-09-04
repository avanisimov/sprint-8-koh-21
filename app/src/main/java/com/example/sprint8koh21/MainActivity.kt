package com.example.sprint8koh21

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Objects

class MainActivity : AppCompatActivity() {

    private var lastOnStopMillis: Long = 0
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d(TAG, "$this onCreate")

        findViewById<LinearLayout>(R.id.btn).setOnClickListener {
            this@MainActivity.finish()
        }
    }

    override fun onStart() {
        super.onStart()
        if (System.currentTimeMillis() - lastOnStopMillis > 15 * 1000L) {
            Log.d(TAG, "$this onStart with pincode")
        } else {
            Log.d(TAG, "$this onStart")
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$this onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$this onPause")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onStop() {
        super.onStop()
        lastOnStopMillis = System.currentTimeMillis()
        Log.d(TAG, "$this onStop lastOnStopMillis=$lastOnStopMillis")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$this onDestroy")
    }


    companion object {
        const val TAG = "SPRINT_8"
    }



}