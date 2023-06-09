package com.network

import android.app.ProgressDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View.GONE
import android.view.View.VISIBLE
import com.example.storage.util.DateUtil
import com.kotlinptoject.R
import kotlinx.android.synthetic.main.activity_progress_dialog.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.progressDialog
import org.jetbrains.anko.selector

class ProgressDialogActivity : AppCompatActivity() {
    private val progressNames = listOf("圆形进度","水平进度条")
    private val progressStyles = intArrayOf(ProgressDialog.STYLE_SPINNER,ProgressDialog.STYLE_HORIZONTAL)
    private var dialog :ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_dialog)
        sp_style.visibility = GONE
        tv_spinner.visibility = VISIBLE
        tv_spinner.setOnClickListener(){
            selector("请选择对话框样式",progressNames){ dialogInterface: DialogInterface, i: Int ->
                tv_spinner.text = progressNames[i]
                if (dialog == null || dialog!!.isShowing)
                    if (progressStyles[i] == ProgressDialog.STYLE_SPINNER){
                        dialog = indeterminateProgressDialog("正在努力加载页面","请稍后")
                        dialog!!.show()
                        handler.postDelayed(closeDialog,5000)

                    }else{
                        dialog = progressDialog("正在努力加载页","请稍后")
                        dialog!!.show()
                        RefreshThread().start()
                    }

            }
        }
    }
    private val closeDialog = Runnable {
        if (dialog!!.isShowing){
            dialog!!.dismiss()
            tv_result.text = "${DateUtil.nowDate} ${tv_spinner.text}加载完成"
        }
    }
    private inner class RefreshThread:Thread(){
        override fun run() {
            for (i in 0..9){
                val message = Message.obtain()
                message.what = 0
                message.arg1 = i *10
                handler.sendMessage(message)
                Thread.sleep(1500)
            }
            handler.sendEmptyMessage(1)
        }
    }
    private val handler = object :Handler(){
        override fun handleMessage(msg: Message) {
           when(msg.what){
               0 -> dialog?.progress  = msg.arg1
               else ->post(closeDialog)
           }
        }
    }
}