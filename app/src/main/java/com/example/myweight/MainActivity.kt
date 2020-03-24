package com.example.myweight

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weight.setOnClickListener {
            val intent = Intent(application, DisplayMessegeActuvity2::class.java)
            startActivity(intent)
        }

        plus_weight.setOnClickListener {
            val intent = Intent(application, DisplayMessageActivity::class.java)
            startActivity(intent)
        }

        date.setOnClickListener {
            val intent = Intent(application, DisplayMessegeActivity3::class.java)
            startActivity(intent)
        }
        plus_date.setOnClickListener{
            val intent = Intent(application, DisplayMessageActivity4::class.java)
            startActivity(intent)
        }

    }

}

