package com.lokesh.remoteaccess

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Function called when the SetAccessKeyButton is clicked
    fun SetAccessKey(view: View) {
        val TAG = "MyActivity"
        Log.d(TAG, "Access key is : "+accessKey_edittext.editableText.toString())
        val sharedPrefe = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPrefe.edit()){
            putString("access_key",accessKey_edittext.toString())
            commit()
            Log.d(TAG, "Access key saved")
        }
    }

    fun getData(view: View) {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        val str_name = sharedPref.getString("access_key", "")
        Toast.makeText(this, "$str_name ", Toast.LENGTH_LONG).show()

    }

}