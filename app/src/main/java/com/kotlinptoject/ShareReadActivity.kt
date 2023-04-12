package com.kotlinptoject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.util.Preference
import org.jetbrains.anko.toast

class ShareReadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_read)

        var preference = Preference(this, "name", "")
        var name:String by preference
        toast("$preference+:$name")
    }
}