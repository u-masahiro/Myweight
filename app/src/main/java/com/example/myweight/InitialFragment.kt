package com.example.myweight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class InitialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_initial, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //buttonを参照
        val weightplusbutton = view.findViewById<Button>(R.id.plus_weight)
        val weightstatusbutton = view.findViewById<Button>(R.id.weight)
        val dateplusbutton = view.findViewById<Button>(R.id.plus_date)
        val datestatusbutton = view.findViewById<Button>(R.id.date)
        //Fragmentクラスをインスタンス化その下も同様
        val weightplusFragment = plusweightFragment()
        val weightstatusFragment = statusweightFragment()
        val dateplusFragment = plusdateFragment()
        val datestatusFragment = statusdateFragment()

        weightplusbutton.setOnClickListener {
            replaceFragment(weightplusFragment)
        }
        weightstatusbutton.setOnClickListener {
            replaceFragment(weightstatusFragment)
        }
        dateplusbutton.setOnClickListener {
            replaceFragment(dateplusFragment)
        }
        datestatusbutton.setOnClickListener {
            replaceFragment(datestatusFragment)
        }
    }

    //R.id.containerに引数で渡されたフラグメントを入れる。
    fun replaceFragment(fragment: Fragment) {
        val myContext  = activity
        val fragmentManager : FragmentManager
        val fragmentTransaction : FragmentTransaction

        if(myContext != null) {
            fragmentManager = myContext.supportFragmentManager
            fragmentTransaction = fragmentManager.beginTransaction()
            // BackStackを設定
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.replace(R.id.container, fragment).commit()
        }
    }
}

