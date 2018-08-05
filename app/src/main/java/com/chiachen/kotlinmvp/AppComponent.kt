package com.chiachen.kotlinmvp

import com.application.library.kotlin.NetworkModule
import com.chiachen.kotlinmvp.data.DataModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by jianjiacheng on 2018/8/5.
 */
@Component(
        modules = arrayOf(AppModule::class, NetworkModule::class, DataModule::class)
)

@Singleton
interface AppComponent : AppGraph {
}