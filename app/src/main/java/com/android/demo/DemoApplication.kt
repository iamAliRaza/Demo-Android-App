package com.android.demo

import android.app.Application
import android.content.Context

// Main Entry Point
class DemoApplication : Application() {

    companion object {
        // static object of application context
        private var appContext: Context? = null
        fun getInstance () =  appContext
    }

    override fun onCreate() {

        // Assign value only if its null ..
        if (appContext == null) appContext = this

        super.onCreate()
    }
}