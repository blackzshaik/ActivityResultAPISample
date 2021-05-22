package com.madtutorial.activityresult

import android.app.Activity
import android.app.Instrumentation
import androidx.activity.result.ActivityResult

const val RESULT_TEXT = "RESULT_TEXT"

fun ActivityResult.isResultOk():Boolean = resultCode == Activity.RESULT_OK