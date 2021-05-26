package com.madtutorial.activityresult

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import androidx.activity.result.contract.ActivityResultContract

class CustomContractParcelable<T : Parcelable?> : ActivityResultContract<Intent,T>(){
    override fun createIntent(context: Context, inputAsIntent: Intent?): Intent {
        return inputAsIntent!!
    }

    override fun parseResult(resultCode: Int, intent: Intent?): T? {
        return if (resultCode == Activity.RESULT_OK){
            return intent?.getParcelableExtra<T>(PARCELABLE_RESULT)
        }else{
            null
        }
    }

}