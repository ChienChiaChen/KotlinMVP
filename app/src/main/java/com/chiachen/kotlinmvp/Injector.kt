package com.chiachen.kotlinmvp

import android.content.Context

/**
 * Created by jianjiacheng on 2018/8/3.
 */

object  Injector {

    fun obtain(context: Context): AppGraph? {
        return App.get(context).injector
    }

    internal fun create(app: App): AppGraph {
        return DaggerAppComponent.builder().appModule(AppModule(app)).build()
    }
}