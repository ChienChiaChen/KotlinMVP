package com.chiachen.kotlinmvp.ui.main

import com.chiachen.kotlinmvp.BasePresenter
import com.chiachen.kotlinmvp.BaseView
import com.chiachen.kotlinmvp.data.api.model.SourceResponse

/**
 * Created by jianjiacheng on 2018/8/5.
 */
interface SourceContract {

    interface View : BaseView<Presenter> {
        fun updateView(list: SourceResponse)
    }

    interface Presenter : BasePresenter {
        fun getData()
    }
}