package com.kotlinptoject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.data.MessageInfo
import kotlinx.android.synthetic.main.activity_act_second.*

class ParcelableSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable_second)
        val request = intent.extras?.getParcelable<MessageInfo>("message")
        tv_response.text = "收到请求信息：\n请求时间为${request?.send_time}\n请求内容为${request?.content}"
    }
}