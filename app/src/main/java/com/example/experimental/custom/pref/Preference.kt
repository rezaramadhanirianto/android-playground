package com.example.experimental.custom.pref

import android.content.Context
import android.content.SharedPreferences
import com.example.experimental.R

object Preference {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), 0)
        editor = sharedPreferences.edit()
    }

    fun addString(key: String, value: String){
        editor.putString(key, value)
        editor.commit()
    }

    fun getString(key: String): String{
        return sharedPreferences.getString(key, "en") ?: "en"
    }
}