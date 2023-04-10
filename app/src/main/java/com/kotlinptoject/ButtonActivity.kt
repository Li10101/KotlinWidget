package com.kotlinptoject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_button.*
import kotlinx.android.synthetic.main.activity_view_pager.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class ButtonActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        btn_click.text = "你点一下"
        btn_click_anonymos.text = "长按"
        //第一种 匿名函数
//        btn_click.setOnClickListener{ v->
//            //kotlin对变量进行类型转换的关键字为as
//            toast("你点击了控件：${(v as Button).text}")
//        }
//        btn_click_anonymos.setOnLongClickListener{v->
//           longToast("你长按了控件：${(v as Button).text}")
//            true
//        }
        //第二种内部类实现
//        btn_click.setOnClickListener(MyClickListener())
//        btn_click_anonymos.setOnLongClickListener(MyLongClickListener())

        //第三种 接口实现方式
        btn_click.setOnClickListener(this)
        btn_click_anonymos.setOnLongClickListener(this)

    }

//    private inner class MyClickListener :View.OnClickListener{
//        override fun onClick(p0: View?) {
//            toast("你点击了控件1：${(p0 as Button).text}")
//        }
//
//    }
//
//    private inner class MyLongClickListener :View.OnLongClickListener{
//        override fun onLongClick(p0: View?): Boolean {
//            toast("你长点击了控件1：${(p0 as Button).text}")
//            return true
//        }
//
//
//    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.btn_click){
            toast("你点击了控件2：${(p0 as Button).text}")
        }

    }

    override fun onLongClick(p0: View): Boolean {
        if (p0.id == R.id.btn_click_anonymos){
            toast("你长点击了控件2：${(p0 as Button).text}")
        }

        return true
    }

}