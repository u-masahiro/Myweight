package com.example.myweight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.content.Context
import android.content.SharedPreferences
import kotlinx.android.synthetic.main.fragment_plusweight.*


class plusweightFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // "DataStore"という名前でインスタンスを生成
        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)

        buttonWrite.setOnClickListener{
            // エディットテキストのテキストを取得
            val stringText = editText.text.toString()

            textWrite.text = stringText

            // 入力文字列を"Input"に書き込む
            val editor = dataStore.edit()
            editor.putString("Input", stringText)

            //editor.commit();
            editor.apply()
        }

        buttonRead.setOnClickListener{
            // "Input"から読み出す
            val str = dataStore.getString("Input", "NoData")

            textRead.text = str

        }
    }

}
