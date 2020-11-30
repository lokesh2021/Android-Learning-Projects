package com.lokesh.layouts2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()

    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(box1_text, box2_text, box3_text, box4_text, box5_text,constraint_layout)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when(view.id){
            R.id.box1_text -> view.setBackgroundColor(Color.RED)
            R.id.box2_text -> view.setBackgroundColor(Color.GREEN)
            R.id.box3_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box4_text -> view.setBackgroundResource(android.R.color.holo_orange_light)
            R.id.box5_text -> view.setBackgroundResource(android.R.color.holo_purple)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}