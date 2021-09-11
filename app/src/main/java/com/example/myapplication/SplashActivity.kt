package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    private val DELAY : Long = 3 * 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide();
        //Delay 3 minutes
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, WordTestActivity::class.java)
            startActivity(intent)
            finish()
        }, DELAY)
    }
}