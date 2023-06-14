package com.example.rick_and_morty.di

import com.example.rick_and_morty.core.utils.Constants
import com.example.rick_and_morty.feature_location.data.LocationRepository
import com.example.rick_and_morty.feature_location.data.remote.LocationApiService
import com.example.rick_and_morty.feature_location.domain.LocationRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object LocationModule {
    @Provides
    fun provideLocationApiService(): LocationApiService{
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(LocationApiService::class.java)
    }

    @Provides
    fun provideLocationRepository(
        @IODispatcher dispatcher: CoroutineDispatcher,
        apiService: LocationApiService
    ): LocationRepository{
        return LocationRepositoryImpl(dispatcher,apiService)
    }
}