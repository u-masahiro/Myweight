package com.example.myweight

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.SharedPreferences
import kotlinx.android.synthetic.main.activity_display_message.*
// Kotlin Android Extensions
import kotlinx.android.synthetic.main.activity_main.*

class DisplayMessageActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)
        // "DataStore"という名前でインスタンスを生成
        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_APPEND)

        buttonWrite.setOnClickListener{
            if(editText.text.toString()==""){
                AlertDialog.Builder(this)
                    .setTitle("ERROR！")
                    .setMessage("入力してください")
                    .setPositiveButton("OK"){ dialog, which -> }
                    .show()
            }
            else{
                // エディットテキストのテキストを取得
                val stringText = editText.text.toString()
                

                // 入力文字列を"Input"に書き込む
                val editor = dataStore.edit()
                editor.putString("Input", stringText)

                //editor.commit();
                editor.apply()
                AlertDialog.Builder(this)
                    .setTitle("保存処理")
                    .setMessage("保存します")
                    .setPositiveButton("OK"){ dialog, which -> }
                    .setNegativeButton("No", { dialog, which ->
                        finish()
                    })
                    .show()
            }
        }
        returnButton.setOnClickListener{
            finish()
        }
    }
}
