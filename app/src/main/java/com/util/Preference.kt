package com.util

import android.content.Context
import android.content.SharedPreferences
import java.lang.IllegalArgumentException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Preference<T>(val context: Context,val name:String,val default:T) :ReadWriteProperty<Any?,T>{


    //通过属性代理初始化共享参数对象
    val prefs: SharedPreferences by lazy { context.getSharedPreferences("default",Context.MODE_PRIVATE) }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name,default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name,value)
    }

    private fun<T> findPreference(name: String,default: T):T = with(prefs){
        val res:Any = when (default){
            is Long -> getLong(name,default)
            is String -> getString(name,default)
            is Int -> getInt(name,default)
            is Boolean ->getBoolean(name,default)
            is Float ->getFloat(name,default)
            else ->throw java.lang.IllegalArgumentException("")
        }!!
        return res as T
    }

    private fun<T> putPreference(name: String,value: T) = with(prefs.edit()){
        when(value){
            is Long -> putLong(name,value)
            is String -> putString(name,value)
            is Int ->putInt(name,value)
            is Boolean ->putBoolean(name,value)
            is Float ->putFloat(name,value)
            else ->throw IllegalArgumentException("")
        }.apply()//commit方法和apply方法都表示提交修改
    }
}