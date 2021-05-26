package com.madtutorial.activityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {

    private lateinit var sendResultButton:Button
    private lateinit var resultEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        sendResultButton = findViewById(R.id.sendResultButton)
        resultEditText = findViewById(R.id.resultEditText)

        sendResultButton.setOnClickListener {
            setActivityResult()
            finish()
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()

    }

    private fun setActivityResult(){
        val intent = Intent()
        intent.putExtra(PARCELABLE_RESULT,SampleModel(description = getString(R.string.the_result_string,resultEditText.text)))
        setResult(Activity.RESULT_OK,intent)

    }
}