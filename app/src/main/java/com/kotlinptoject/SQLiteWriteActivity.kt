package com.kotlinptoject

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import com.database.UserDBHelper
import com.example.storage.bean.UserInfo
import com.example.storage.util.DateUtil
import kotlinx.android.synthetic.main.activity_sqlite_write.*
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

class SQLiteWriteActivity : AppCompatActivity() {
    private val types = listOf("未婚","已婚")
    private lateinit var mUserDBHelper:UserDBHelper
    private var bMarried = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_write)

        mUserDBHelper = UserDBHelper.getINstance(this)
        sp_married.visibility = GONE
        tv_spinner.visibility = VISIBLE
        tv_spinner.text = types[0]
        tv_spinner.setOnClickListener {
            selector("请选择婚姻状况", types) { dialogInterface: DialogInterface, i: Int ->
                tv_spinner.text = types[i]
                bMarried = if (i == 0) false else true
            }
        }
        btn_save.setOnClickListener{
            when{
                et_name.text.isEmpty() -> toast("请先填写姓名")
                et_age.text.isEmpty() -> toast("请先填写年龄")
                et_height.text.isEmpty() -> toast("请先填写身高")
                et_weight.text.isEmpty() -> toast("请先填写体重")
                else ->{
                    val info = UserInfo(name = et_name.text.toString(),
                        age = et_age.text.toString().toInt(),
                        height = et_height.text.toString().toLong(),
                        weight = et_weight.text.toString().toFloat(),
                        married = bMarried,
                        update_time = DateUtil.nowDateTime)
                    mUserDBHelper.insert(info)
                    toast("数据写入SQLIT数据库")
                }
            }
        }
    }
}