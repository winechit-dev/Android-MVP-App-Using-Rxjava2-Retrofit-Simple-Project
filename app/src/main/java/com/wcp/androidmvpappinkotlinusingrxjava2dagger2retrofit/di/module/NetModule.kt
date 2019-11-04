package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.di.module

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.BuildConfig
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.network.INetworkApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetModule {

    @Provides
    fun getHeaders() : HashMap<String ,String>{
        val param= HashMap<String , String>()
        param.put("Content-Type", "application/json")
        return param
    }
    @Provides
    protected fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return interceptor
    }
    @Provides
    fun provideRetrofit(gson: Gson):Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
    }

    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideNetworkService(retrofit: Retrofit) : INetworkApi {
        return retrofit.create(INetworkApi::class.java)
    }

    @Provides
    fun getTimeOut() : Int{
        return 30
    }
    @Provides
    protected fun provideOkHttpClientDefault(interceptor: HttpLoggingInterceptor, headers: HashMap<String, String>, timeout: Int): OkHttpClient {
        val okBuilder = OkHttpClient.Builder()
        okBuilder.addInterceptor(interceptor)
        okBuilder.addInterceptor { chain ->
            val request = chain.request()
            val builder = request.newBuilder()

            if (headers != null && headers.size > 0) {
                for ((key, value) in headers) {
                    builder.addHeader(key, value)
                    Log.e(key, value)
                }
            }
            chain.proceed(builder.build())
        }

//        val timeout = getTimeOut()
        okBuilder.connectTimeout(timeout.toLong(), TimeUnit.SECONDS)
        okBuilder.readTimeout(timeout.toLong(), TimeUnit.SECONDS)
        okBuilder.writeTimeout(timeout.toLong(), TimeUnit.SECONDS)

        return okBuilder.build()

    }
}