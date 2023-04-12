package com.kotlinptoject

import android.app.Application
import java.lang.IllegalArgumentException
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }


//    //单例的第一种方式：声明一个简单的Application属性
//    companion object{
//        //情况一：声明可空的属性
////        private var instance:MainApplication?=null
////        fun instance() = instance!!
//        //情况二：声明延迟初始化属性
//        private lateinit var instance:MainApplication
//        fun instance() = instance
//    }


    //借助Delegates生成委托属性单例化
//    companion object{
//        private var instance:MainApplication by Delegates.notNull()
//        fun instance() = instance
//
//    }
    companion object{
        private var instance:MainApplication by NotNullSingleValueVar()
    }
}

class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {
    private var value:T?=null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value?:throw IllegalArgumentException("")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null)value else throw IllegalArgumentException("")
    }

}
