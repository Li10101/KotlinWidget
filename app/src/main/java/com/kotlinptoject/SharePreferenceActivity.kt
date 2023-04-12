package com.kotlinptoject

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.example.storage.util.DateUtil
import com.util.Preference
import kotlinx.android.synthetic.main.activity_share_preference.*
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

class SharePreferenceActivity : AppCompatActivity() {
    private val types = listOf<String>("未婚","已婚")
    private var bMarried = false
    private var name :String by Preference(this,"name","")
    private var age:Int by Preference(this,"age",0)
    private var height: Long by Preference(this, "height", 0)
    private var weight: Float by Preference(this, "weight", 0f)
    private var married: Boolean by Preference(this, "married", false)
    private var update_time: String by Preference(this, "update_time", "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_preference)
        sp_married.visibility = View.GONE
        tv_spinner.visibility = VISIBLE
        tv_spinner.text = types[0]
        tv_spinner.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
               selector("请选择婚姻状况",types){ dialogInterface: DialogInterface, i: Int ->
                   tv_spinner.text = types[i]
                   bMarried = if (i==0)false else true

               }
            }
        })
        btn_save.setOnClickListener(){
            when{
                et_name.text.isEmpty() ->toast("姓名")
                et_age.text.isEmpty() ->toast("年龄")
                et_height.text.isEmpty() ->toast("身高")
                et_weight.text.isEmpty() ->toast("体重")
                else ->{
                    name = et_name.text.toString()
                    age = et_age.text.toString().toInt()
                    height = et_height.text.toString().toLong()
                    weight = et_weight.text.toString().toFloat()
                    married = bMarried
                    update_time = DateUtil.nowDateTime
                    toast("数据已写入共享参数"+
                            "\n　name的取值为$name" +
                            "\n　age的取值为$age" +
                            "\n　height的取值为$height" +
                            "\n　weight的取值为$weight" +
                            "\n　married的取值为$married" +
                            "\n　update_time的取值为$update_time")
                }
            }


        }

    }
}