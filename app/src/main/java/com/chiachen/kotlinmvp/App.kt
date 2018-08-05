package com.chiachen.kotlinmvp

import android.app.Application
import android.content.Context

/**
 * Created by jianjiacheng on 2018/8/3.
 */

class App :Application() {

    internal var injector: AppGraph? = null
        private set

    override fun onCreate() {
        super.onCreate()

        injector = Injector.create(this)
        injector!!.inject(this)
    }

    companion object {

        operator fun get(context: Context): App {
            return context.applicationContext as App
        }
    }
}