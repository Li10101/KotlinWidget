package com.kotlinptoject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_chack_box.*
import kotlinx.android.synthetic.main.activity_main.view.*

class ChackBoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chack_box)
        ck_select.isChecked = false
        ck_select.setOnCheckedChangeListener{
            buttonView,isChecked -> tv_select.text = "你${if(isChecked){"勾线"}else{"取消勾选"}}了复选框"
        }
    }
}