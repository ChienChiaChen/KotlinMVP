package com.chiachen.kotlinmvp.data.source

import com.chiachen.kotlinmvp.data.api.model.SourceResponse
import com.chiachen.kotlinmvp.data.api.service.SourceService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by jianjiacheng on 2018/8/5.
 */
class RemoteSourceDataSource(var sourceService: SourceService) : SourceDataSource {

    override fun getSource(callback: SourceDataSource.LoadDataCallback) {
        sourceService
                .getSources()
                .enqueue(object: Callback<SourceResponse>{
                    override fun onResponse(call: Call<SourceResponse>, response: Response<SourceResponse>) {
                        callback.onDataLoaded(response.body())
                    }
                    override fun onFailure(call: Call<SourceResponse>, t: Throwable) {
                        callback.onError(t)
                    }
                })
    }
}