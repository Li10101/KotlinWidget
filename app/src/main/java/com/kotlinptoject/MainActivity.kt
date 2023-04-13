package com.kotlinptoject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.data.MessageInfo
import com.network.AsyncTaskActivity
import com.network.JsonParseActivity
import com.network.MessageActivity
import com.network.ProgressDialogActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.newTask
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {
    val origin:Float = 65.0f;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.text ="按钮"
        btn.setOnClickListener(){
            val intent = Intent(this,ButtonActivity::class.java)
            startActivity(intent)

            Log.e("ee","eee")
        }
       checkbox.setOnClickListener{
           val checkBoxIntent = Intent(this,ChackBoxActivity::class.java)
           checkBoxIntent.extras?.putString("","")
           startActivity(checkBoxIntent.newTask())
       }
        radioButton.setOnClickListener{v->
            val checkBoxIntent = Intent(this,RadioButtonActivity::class.java)
            startActivity(checkBoxIntent)
        }
        linearButton.setOnClickListener(){
            //简写版跳转
            startActivity<LinearLayoutActivity>()
        }

        activityButton.setOnClickListener(){
            //第一种跳转携带参数
//            startActivity<ActSecondActivity>(
//                "request_time" to "2023_04_06",
//                "request_content" to "你好"
//            )
            //第二种Pair
//            startActivity<ActSecondActivity>(
//                Pair("request_time","2023_04_06"),
//                Pair("request_content" , "你好")
//            )
            //第三种传递序列化数据
//            val request = MessageInfo("你好呀","2023_04_06");
//            startActivity<ParcelableSecondActivity>(
//                Pair("message",request),
//            )
            //第四种处理返回值
            val request1 = MessageInfo("你好呀","2023_04_06");
            startActivityForResult<ActSecondActivity>(
               0, Pair("message",request1))
        }
        alertButton.setOnClickListener(){
            startActivity<AlertDialogActivity>()
        }

        spannerButton.setOnClickListener(){
            startActivity<SpinnerActivity>()
        }
        viewPagerButton.setOnClickListener(){
            startActivity<ViewPagerActivity>()
        }
        fragmentButton.setOnClickListener(){
            startActivity<FragmentDynamicActivity>()
        }
        tabLayoutButton.setOnClickListener(){
            startActivity<TabLayoutActivity>()
        }
        sharePreference.setOnClickListener(){
            startActivity<ShareReadActivity>()
        }

        sql_write.setOnClickListener(){
            startActivity<SQLiteWriteActivity>()
        }
        sql_read.setOnClickListener(){
            startActivity<SQLiteReadActivity>()
        }
        file_path.setOnClickListener(){
            startActivity<FilePathActivity>()
        }
        thread.setOnClickListener(){
            startActivity<MessageActivity>()
        }
        progress_button.setOnClickListener(){
            startActivity<ProgressDialogActivity>()
        }
        async_button.setOnClickListener(){
            startActivity<AsyncTaskActivity>()
        }
        json.setOnClickListener(){
            startActivity<JsonParseActivity>()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null){
            val response = data.extras?.getParcelable<MessageInfo>("message")
            if (response != null) {
                tv_result.text = "消息回来了${response.send_time}佳航${response.content}"
            }
        }
    }
}
