package com.madtutorial.activityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //traditional way to add fragment to activity
//        supportFragmentManager!!.
//        beginTransaction().
//        add(R.id.homeFragmentContainer,HomeFragment(),"FragmentOne").commit()
//
        //kotlin getting better everyday
        supportFragmentManager.commit {
            add(R.id.homeFragmentContainer,HomeFragment())
        }


    }


}