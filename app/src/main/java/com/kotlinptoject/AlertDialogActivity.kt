package com.kotlinptoject

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_alert_dialog.*
import org.jetbrains.anko.alert

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        //第一种写法
//        alert.setOnClickListener(){v->
//            val builder = AlertDialog.Builder(this)
//            builder.setTitle("尊敬的用户")
//            builder.setMessage("你真的要卸载吗")
//            builder.setPositiveButton("残忍卸载"){
//                dialog,which ->
//                tv_alert.text = "离开"
//            }
//            builder.setNegativeButton("我再想想"){ dialogInterface, i ->
//                tv_alert.text = "再想想"
//            }
//            builder.create().show()
//        }
        //第二种简写 
        alert.setOnClickListener(){
            alert("你真的卸载我妈","尊敬的用户"){
                positiveButton("残忍卸载"){
                    tv_alert.text = "离开喽"
                }
                negativeButton("再想想"){
                    tv_alert.text = "在想一下"
                }
            }.show()
        }
    }
}