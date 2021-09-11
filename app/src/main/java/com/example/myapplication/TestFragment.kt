package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView

import android.widget.ProgressBar
import java.util.ArrayList


class TestFragment : Fragment(R.layout.fragment_game) {

    private var textView : androidx.appcompat.widget.AppCompatTextView? = null
    private var answerFirst : androidx.appcompat.widget.AppCompatTextView? = null
    private var answerSecond : androidx.appcompat.widget.AppCompatTextView? = null
    private var answerThird : androidx.appcompat.widget.AppCompatTextView? = null
    private var answerFourth : androidx.appcompat.widget.AppCompatTextView? = null
    private var buttonClose : androidx.appcompat.widget.AppCompatButton? = null
    private var progressBar: ProgressBar? = null
    private var progressText: TextView? = null
    var time = 20 //for timer
    var angle = 100 //for timer angle

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_game, container, false);

        buttonClose = view.findViewById(R.id.close_button)
        buttonClose?.setOnClickListener{
            fragmentManager?.popBackStack()
        }
        prepareView(view)
        startTimer(view)
        return view
    }

    fun prepareView(view: View){
        val answers : ArrayList<String>? = arguments?.getStringArrayList("answers")

        //Log.d("TAG", answers.toString())

        textView = view.findViewById(R.id.word_card)
        answerFirst = view.findViewById(R.id.answer_first)
        answerSecond = view.findViewById(R.id.answer_second)
        answerThird = view.findViewById(R.id.answer_third)
        answerFourth = view.findViewById(R.id.answer_fourth)

        textView?.setText( arguments?.getString("word"))
        answerFirst?.setText( answers?.get(0).toString())
        answerSecond?.setText( answers?.get(1).toString())
        answerThird?.setText( answers?.get(2).toString())
        answerFourth?.setText( answers?.get(3).toString())
    }

    fun startTimer(view: View){
        progressBar = view.findViewById(R.id.progress_bar);
        progressText = view.findViewById(R.id.progress_text);
        var handler : Handler = Handler();

        handler.postDelayed(object :Runnable{
            override fun run() {
                if (angle >= 0 && time >= 0) {
                    progressText!!.text = "" + time
                    progressBar!!.progress = angle
                    angle = angle - 5
                    time--
                    handler.postDelayed(this, 500)
                } else {
                    handler.removeCallbacks(this)
                }
            }
        },200)

    }


}

