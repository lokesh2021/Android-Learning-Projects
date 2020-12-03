package com.lokesh.birthdaygreetingcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun GenerateCard(view: View) {

        val name = name_edittext.editableText.toString()

        Toast.makeText(this,"Generating Card for $name",Toast.LENGTH_SHORT).show()

        val intent = Intent(this,BirthdayCard::class.java)
        intent.putExtra(BirthdayCard.INTENT_NAME,name)
        startActivity(intent)
    }
}