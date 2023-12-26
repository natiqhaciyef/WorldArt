package com.natiqhaciyef.worldart.domain.di

import com.natiqhaciyef.worldart.data.source.ArchitectureSource
import com.natiqhaciyef.worldart.data.source.HistorySource
import com.natiqhaciyef.worldart.data.source.PaintingSource
import com.natiqhaciyef.worldart.data.source.ScienceSource
import com.natiqhaciyef.worldart.data.source.TravelSource
import com.natiqhaciyef.worldart.domain.repository.ArchitectureRepository
import com.natiqhaciyef.worldart.domain.repository.HistoryRepository
import com.natiqhaciyef.worldart.domain.repository.PaintingRepository
import com.natiqhaciyef.worldart.domain.repository.ScienceRepository
import com.natiqhaciyef.worldart.domain.repository.TravelRepository
import com.natiqhaciyef.worldart.domain.repository.impl.ArchitectureRepositoryImpl
import com.natiqhaciyef.worldart.domain.repository.impl.HistoryRepositoryImpl
import com.natiqhaciyef.worldart.domain.repository.impl.PaintingRepositoryImpl
import com.natiqhaciyef.worldart.domain.repository.impl.ScienceRepositoryImpl
import com.natiqhaciyef.worldart.domain.repository.impl.TravelRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideArchitectureRepository(ds: ArchitectureSource) =
        ArchitectureRepositoryImpl(ds) as ArchitectureRepository

    @Provides
    @Singleton
    fun provideHistoryRepository(ds: HistorySource) =
        HistoryRepositoryImpl(ds) as HistoryRepository

    @Provides
    @Singleton
    fun providePaintingRepository(ds: PaintingSource) =
        PaintingRepositoryImpl(ds) as PaintingRepository

    @Provides
    @Singleton
    fun provideScienceRepository(ds: ScienceSource) =
        ScienceRepositoryImpl(ds) as ScienceRepository

    @Provides
    @Singleton
    fun provideTravelRepository(ds: TravelSource) =
        TravelRepositoryImpl(ds) as TravelRepository

}