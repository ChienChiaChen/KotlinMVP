package com.chiachen.kotlinmvp.data.source

import com.chiachen.kotlinmvp.data.api.model.SourceResponse

/**
 * Created by jianjiacheng on 2018/8/5.
 */
interface SourceDataSource {
    fun getSource(callback: LoadDataCallback)

    interface LoadDataCallback {
        fun onDataLoaded(sourceResponse: SourceResponse)
        fun onError(throwable: Throwable)
    }
}