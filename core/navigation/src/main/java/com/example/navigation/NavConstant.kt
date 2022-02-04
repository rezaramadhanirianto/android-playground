package com.example.navigation

import android.content.Context
import com.example.navigation.R
import javax.inject.Inject

class NavConstant @Inject constructor(val context: Context) {
    val homeFragment = context.getString(R.string.home_fragment)
}