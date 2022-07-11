package com.example.lyricsnake.utils

import com.example.lyricsnake.repository.remote.GeniusService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteSource{

    @Singleton
    @Provides
    fun provideHeaderInterceptor() : Interceptor =
        Interceptor {
            it.proceed(
                it.request().newBuilder()
                    .addHeader("x-rapidapi-host","genius.p.rapidapi.com")
                    .addHeader("x-rapidapi-key","aabb09b77fmsh443ce25b9ae8eb9p176ed2jsn5e58e207ebd6")
                    .build()
            )
        }

    @Singleton
    @Provides
    fun provideHttpClient(headerInterceptor: Interceptor): OkHttpClient =
        OkHttpClient().newBuilder()
            .addInterceptor(headerInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofitInterface(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://genius.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun provideGeniusService(retrofit: Retrofit) : GeniusService =
        retrofit.create(GeniusService::class.java)
}

