package com.example.myweight

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // コードからフラグメントを追加
        if (savedInstanceState == null) {
            val baseFragment = InitialFragment()
            replaceFragment(baseFragment)
        }
    }
    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        // BackStackを設定
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(R.id.container2, fragment).commit()
    }
}


