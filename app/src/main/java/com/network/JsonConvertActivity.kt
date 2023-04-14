package com.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storage.bean.UserInfo
import com.google.gson.Gson
import com.kotlinptoject.R
import kotlinx.android.synthetic.main.activity_json_convert.*

class JsonConvertActivity : AppCompatActivity() {
    private val user = UserInfo(name = "李振", age = 25, height = 160L, weight = 45.0f, married = false)
    private val json = Gson().toJson(user)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_convert)
        btn_origin_json.setOnClickListener(){tv_json.text = "json串内容如下：\n$json"}
        btn_convert_json.setOnClickListener(){
            val newUser = Gson().fromJson(json,UserInfo::class.java)
            tv_json.text =  "从json串解析而来的用户信息如下：" +
                    "\n\t姓名=${newUser.name}" +
                    "\n\t年龄=${newUser.age}" +
                    "\n\t身高=${newUser.height}" +
                    "\n\t体重=${newUser.weight}" +
                    "\n\t婚否=${newUser.married}"
        }

    }
}