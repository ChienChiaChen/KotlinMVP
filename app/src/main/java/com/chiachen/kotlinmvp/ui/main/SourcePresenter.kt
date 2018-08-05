package com.chiachen.kotlinmvp.ui.main

import com.chiachen.kotlinmvp.data.api.model.SourceResponse
import com.chiachen.kotlinmvp.data.source.SourceDataSource
import com.chiachen.kotlinmvp.data.source.SourceRepository

/**
 * Created by jianjiacheng on 2018/8/5.
 */
class SourcePresenter(private val view : SourceContract.View, private val repository: SourceRepository) : SourceContract.Presenter {
    init {
        this.view.setPresenter(this)
    }

    override fun start() {
        getData()
    }

    override fun getData() {
        repository.getSource(object : SourceDataSource.LoadDataCallback {
            override fun onDataLoaded(sourceResponse: SourceResponse) {
                view.updateView(sourceResponse)
            }

            override fun onError(throwable: Throwable) {

            }

        })
    }
}