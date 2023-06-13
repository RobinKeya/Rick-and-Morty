package com.example.rick_and_morty.di

import com.example.rick_and_morty.core.utils.Constants
import com.example.rick_and_morty.feature_characters.data.CharacterRepository
import com.example.rick_and_morty.feature_characters.data.remote.CharacterApiService
import com.example.rick_and_morty.feature_characters.domain.CharacterRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharacterModule {
    @Singleton
    @Provides
    fun provideCharacterApiService(): CharacterApiService{
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(CharacterApiService::class.java)
    }
    @Provides
    fun provideCharacterRepository(
        @IODispatcher dispatcher: CoroutineDispatcher,
        apiService: CharacterApiService
    ): CharacterRepository {
        return CharacterRepositoryImpl(dispatcher,apiService)
    }
}