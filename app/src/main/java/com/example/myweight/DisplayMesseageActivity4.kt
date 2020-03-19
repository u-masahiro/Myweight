package com.example.myweight

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle
import android.widget.TextView
import android.view.View
import android.widget.Button
import java.util.*
import android.app.DatePickerDialog
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_display_messeage4.*
import java.text.SimpleDateFormat


class DisplayMesseageActivity4 : AppCompatActivity() {

    var button_date: Button? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the references from layout file
        textview_date = this.text_view_date_1
        button_date = this.button_date_1

        textview_date!!.text = "--/--/----"

        // create an OnDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        button_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@DisplayMesseageActivity4,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })
    }

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date!!.text = sdf.format(cal.getTime())
    }

}
