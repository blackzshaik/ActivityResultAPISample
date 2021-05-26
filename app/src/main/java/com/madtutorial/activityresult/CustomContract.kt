package com.madtutorial.activityresult

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

/**
 * This custom contract is kept for  reference on how to implement a perfect type safe custom contract.
 */
class CustomContract : ActivityResultContract<Int,String>(){

    override fun createIntent(context: Context, input: Int?): Intent {
        //optional:
        //we can add the input to intent like
//         val intent = Intent(context,SecondActivity::class.java)
//        intent.putExtra("INPUT",input)
//        return intent
        return  Intent(context,SecondActivity::class.java)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return if (resultCode == Activity.RESULT_OK){
            intent?.getStringExtra(RESULT_TEXT)
        }else{
            null
        }
    }

}