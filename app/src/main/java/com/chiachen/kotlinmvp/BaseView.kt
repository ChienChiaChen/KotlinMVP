package com.chiachen.kotlinmvp

/**
 * Created by jianjiacheng on 2018/8/3.
 */

interface BaseView<T>{
    fun setPresenter(presenter: T)
}