package com.kotlinptoject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_radio_button.*

class RadioButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)
        rg_sex.check(R.id.rb_male)
        rg_sex.setOnCheckedChangeListener(){ radioGroup: RadioGroup, i: Int ->
            tv_sex.text = when(i){
                R.id.rb_male -> "哇偶，是个刷个"
                R.id.rb_female ->"哇偶，是个美女"
                else -> ""
            }
        }
    }
}