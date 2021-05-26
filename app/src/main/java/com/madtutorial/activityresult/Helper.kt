package com.madtutorial.activityresult

import android.app.Activity
import android.app.Instrumentation
import androidx.activity.result.ActivityResult

const val RESULT_TEXT = "RESULT_TEXT"
const val LAUNCH_CODE = 331

const val PARCELABLE_RESULT = "PARCELABLE_RESULT"

fun ActivityResult.isResultOk():Boolean = resultCode == Activity.RESULT_OK