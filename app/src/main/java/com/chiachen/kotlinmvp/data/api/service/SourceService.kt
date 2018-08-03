package com.chiachen.kotlinmvp.data.api.service

import com.chiachen.kotlinmvp.data.api.model.SourceResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by jianjiacheng on 2018/8/3.
 */

interface SourceService {

    @GET("sources")
    fun getSources(): Call<SourceResponse>
}