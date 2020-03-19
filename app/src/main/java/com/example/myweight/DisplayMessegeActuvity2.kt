package com.example.myweight

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_display_messege_actuvity2.*

class DisplayMessegeActuvity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_messege_actuvity2)

        buttonRead.setOnClickListener{
            val pref = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
            // "Input"から読み出す
            val str = pref.getString("Input", "NoData")
            textRead.text = str
        }
    }
}
