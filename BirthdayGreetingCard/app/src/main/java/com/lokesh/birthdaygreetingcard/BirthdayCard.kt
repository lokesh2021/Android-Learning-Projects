package com.lokesh.birthdaygreetingcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_birthday_card.*

class BirthdayCard : AppCompatActivity() {

    companion object{  //by creating companion object you can access all its elements like a static/global variable
        val INTENT_NAME = "intent_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_card)

    val name = intent.getStringExtra(INTENT_NAME)

        birthdayGreeting_text.text = "Happy Birthday\n $name!"

    }
}