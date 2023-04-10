package com.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MessageInfo(val content:String,val send_time:String):Parcelable {
}