package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.core.view.isVisible


class WordTestActivity : AppCompatActivity() {

    private var button: androidx.appcompat.widget.AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_word_test)
        supportActionBar?.hide();
        button = findViewById(R.id.button_start);

        button?.setOnClickListener{
            startGame()
        }
    }

    fun startGame(){
        val myFragment = TestFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val answers  = ArrayList<String>()
        val data = Bundle().apply {
            putString("word", "Visualize")
            answers.add("Görselleştirmek")
            answers.add("Altında")
            answers.add("Bağış")
            answers.add("Ensülin")
            putStringArrayList("answers", answers)
        }
        myFragment.arguments = data
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(R.id.flFragment, myFragment).commit()
    }
}