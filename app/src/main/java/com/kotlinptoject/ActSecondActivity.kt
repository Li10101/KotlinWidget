package com.kotlinptoject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.data.MessageInfo
import kotlinx.android.synthetic.main.activity_act_second.*

class ActSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_second)
        val bundle = intent.extras
        var request_time = bundle?.getString("request_time")
        var string = bundle?.getString("request_content")
        //tv_response.text = "收到请求信息：\n请求时间为${request_time}\n请求内容为${string}"
        //第四种处理返回参数
        val mesage = intent.extras?.getParcelable<MessageInfo>("message")
        tv_response.text = "收到请求信息：\n请求时间为${mesage?.send_time}\n请求内容为${mesage?.content}"
        tv_response.setOnClickListener(){
            val intent = Intent();
            intent.putExtra("message",mesage)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}