package com.chiachen.kotlinmvp

import com.chiachen.kotlinmvp.ui.main.MainActivity

/**
 * Created by jianjiacheng on 2018/8/3.
 */

interface AppGraph {
    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}