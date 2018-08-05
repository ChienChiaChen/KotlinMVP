package com.chiachen.kotlinmvp.data.source

import com.chiachen.kotlinmvp.data.api.model.SourceResponse

/**
 * Created by jianjiacheng on 2018/8/5.
 */
class SourceRepository (var remoteDataSource: RemoteSourceDataSource) : SourceDataSource {

    override fun getSource(callback: SourceDataSource.LoadDataCallback) {
        remoteDataSource.getSource(object : SourceDataSource.LoadDataCallback {
            override fun onDataLoaded(sourceResponse: SourceResponse) {
                callback.onDataLoaded(sourceResponse)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }

        })
    }
}