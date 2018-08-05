package com.chiachen.kotlinmvp.data

import com.chiachen.kotlinmvp.data.api.service.SourceService
import com.chiachen.kotlinmvp.data.source.RemoteSourceDataSource
import com.chiachen.kotlinmvp.data.source.SourceRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by eminartiys on 8/5/17.
 */
@Module
class DataModule() {

    @Provides
    @Singleton
    internal fun provideRemoteSourceDataSource(sourceService: SourceService): RemoteSourceDataSource {
        return RemoteSourceDataSource(sourceService)
    }

    @Provides
    @Singleton
    internal fun provideSourceRepository(remoteSourceDataSource: RemoteSourceDataSource): SourceRepository {
        return SourceRepository(remoteSourceDataSource)
    }

}