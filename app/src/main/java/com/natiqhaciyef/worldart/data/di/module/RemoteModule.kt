package com.natiqhaciyef.worldart.data.di.module

import com.natiqhaciyef.worldart.data.network.config.NetworkConfig
import com.natiqhaciyef.worldart.data.network.service.ArchService
import com.natiqhaciyef.worldart.data.network.service.HistoryService
import com.natiqhaciyef.worldart.data.network.service.PaintingService
import com.natiqhaciyef.worldart.data.network.service.PostService
import com.natiqhaciyef.worldart.data.network.service.ScienceService
import com.natiqhaciyef.worldart.data.network.service.TravelService
import com.natiqhaciyef.worldart.data.source.ArchitectureSource
import com.natiqhaciyef.worldart.data.source.HistorySource
import com.natiqhaciyef.worldart.data.source.PaintingSource
import com.natiqhaciyef.worldart.data.source.PostSource
import com.natiqhaciyef.worldart.data.source.ScienceSource
import com.natiqhaciyef.worldart.data.source.TravelSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(NetworkConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(NetworkConfig.logger.build())
        .build()

    @Provides
    @Singleton
    fun provideArchService(retrofit: Retrofit): ArchService =
        retrofit.create(ArchService::class.java)

    @Provides
    @Singleton
    fun provideHistoryService(retrofit: Retrofit): HistoryService =
        retrofit.create(HistoryService::class.java)

    @Provides
    @Singleton
    fun providePaintingService(retrofit: Retrofit): PaintingService =
        retrofit.create(PaintingService::class.java)

    @Provides
    @Singleton
    fun provideScienceService(retrofit: Retrofit): ScienceService =
        retrofit.create(ScienceService::class.java)

    @Provides
    @Singleton
    fun provideTravelService(retrofit: Retrofit): TravelService =
        retrofit.create(TravelService::class.java)

    @Provides
    @Singleton
    fun providePostService(retrofit: Retrofit): PostService =
        retrofit.create(PostService::class.java)


    @Provides
    @Singleton
    fun provideArchitectureSource(service: ArchService) = ArchitectureSource(service)

    @Provides
    @Singleton
    fun provideHistorySource(service: HistoryService) = HistorySource(service)

    @Provides
    @Singleton
    fun providePaintingSource(service: PaintingService) = PaintingSource(service)

    @Provides
    @Singleton
    fun provideScienceSource(service: ScienceService) = ScienceSource(service)

    @Provides
    @Singleton
    fun provideTravelSource(service: TravelService) = TravelSource(service)

    @Provides
    @Singleton
    fun providePostSource(service: PostService) = PostSource(service)
}