package com.madtutorial.activityresult

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SampleModel(val description:String,val id:Int = 0): Parcelable