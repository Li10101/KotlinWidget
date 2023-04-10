package com.kotlinptoject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_linear_layout.*
import org.jetbrains.anko.dip

class LinearLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)
        ll_margin.orientation == LinearLayout.HORIZONTAL
        ll_margin.gravity =Gravity.CENTER
        b1.setOnClickListener(){
            var params = ll_margin.layoutParams as LinearLayout.LayoutParams
            params.setMargins(0,dip(50),0,dip(50))
            ll_margin.layoutParams = params
        }
    }
}