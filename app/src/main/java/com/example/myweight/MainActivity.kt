package com.example.myweight

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_display_message.*
import kotlinx.android.synthetic.main.activity_main.*
import javax.xml.datatype.DatatypeConstants.MONTHS

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
            val intent = Intent(application, DisplayMesseageActivity4::class.java)
            startActivity(intent)
        }

    }

}

