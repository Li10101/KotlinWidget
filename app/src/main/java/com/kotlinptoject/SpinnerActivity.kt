package com.kotlinptoject

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_spinner.*
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

class SpinnerActivity : AppCompatActivity() {

    //private val startArray = arrayOf("水星","金星","火星","木星","土星");
    private val startlistArray = listOf("水星","金星","火星","木星","土星");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        //第一中
        //initSpinner();
        //第二种
        tv_sp.text= startlistArray[0]
        tv_sp.setOnClickListener(){
            selector("请选择行星",startlistArray){ dialogInterface: DialogInterface, i: Int ->
                tv_sp.text = startlistArray[i]
            }
        }
    }

//    private fun initSpinner(){
//        val startAdapter = ArrayAdapter(this,R.layout.item_select, startArray)
//        startAdapter.setDropDownViewResource(R.layout.item_dropdown)
//        val sp = findViewById<View>(R.id.sp_dialog) as Spinner
//        sp.prompt = "请选择恒星"
//        sp.adapter = startAdapter
//        sp.setSelection(0)
//        sp.onItemSelectedListener = MySelectedListener()
//
//    }
//
//    internal inner class MySelectedListener : AdapterView.OnItemSelectedListener{
//        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//           toast("您选择的行星是${startArray[p2]}")
//        }
//
//        override fun onNothingSelected(p0: AdapterView<*>?) {
//
//        }
//
//
//    }
}