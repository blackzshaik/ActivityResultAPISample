package com.madtutorial.activityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private val secondActivityWithResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.isResultOk()){
            if (result.data?.hasExtra(RESULT_TEXT)!!){
                resultTextView.text = result.data!!.extras?.getString(RESULT_TEXT) ?: "No Result Provided"
            }
        }
    }

    private lateinit var getResultButton:Button
    private lateinit var resultTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getResultButton = findViewById(R.id.getResultButton)
        resultTextView = findViewById(R.id.resultTextView)

        getResultButton.setOnClickListener {
            secondActivityWithResult.launch(Intent(this,SecondActivity::class.java))
        }
    }


}