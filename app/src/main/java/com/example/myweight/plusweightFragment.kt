package com.example.myweight

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Context
import kotlinx.android.synthetic.main.fragment_plusweight.*


class plusweightFragment : Fragment() {
    lateinit var dataStore: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_plusweight, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // "DataStore"という名前でインスタンスを生成
        //ActivityがNULLの場合を無視をしている(‼)
        //val dataStore: SharedPreferences = activity!!.getSharedPreferences("DataStore", Context.MODE_PRIVATE)

        //NULLチェック済み
        activity?.let{
             dataStore=it.getSharedPreferences("DataStore", Context.MODE_PRIVATE)
        }



        buttonWrite.setOnClickListener {
            // エディットテキストのテキストを取得
            val stringText = editText.text.toString()

            textWrite.text = stringText

            // 入力文字列を"Input"に書き込む
            val editor = dataStore.edit()
            editor.putString("Input", stringText)

            //editor.commit();
            editor.apply()
        }

        buttonRead.setOnClickListener {
            // "Input"から読み出す
            val str = dataStore.getString("Input", "NoData")

            textRead.text = str

        }
    }
}
