package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var application: Application) {

    lateinit var applicationInst: Application

    init {
        applicationInst = application
    }


    @Provides
    @Singleton
    fun provideApplication(): Application {
        return applicationInst
    }
}