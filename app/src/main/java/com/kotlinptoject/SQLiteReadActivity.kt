package com.kotlinptoject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.database.UserDBHelper
import kotlinx.android.synthetic.main.activity_sqlite_read.*

class SQLiteReadActivity : AppCompatActivity() {
    private lateinit var mHelper:UserDBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_read)

        mHelper = UserDBHelper.getINstance(this)
        readSQLite()
        btn_delete.setOnClickListener{
            mHelper.deleteAll()
            readSQLite()
        }
    }

    private fun readSQLite() {

        var userArray = mHelper.queryAll()
        var desc = "数据库查询到${userArray.size}条记录，详情如下："
        for (i in userArray.indices){
            val item = userArray[i]
            desc = "$desc\n第${i+1}条记录信息如下：" +
                    "\n　姓名为${item.name}" +
                    "\n　年龄为${item.age}" +
                    "\n　身高为${item.height}" +
                    "\n　体重为${item.weight}" +
                    "\n　婚否为${item.married}" +
                    "\n　更新时间为${item.update_time}"
        }
        if (userArray.isEmpty()){
            desc = "数据库查询到的记录为空"
        }
        tv_sqlite.text = desc



    }
}