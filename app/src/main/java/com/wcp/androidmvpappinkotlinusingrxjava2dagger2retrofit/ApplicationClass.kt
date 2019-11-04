package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit

import android.app.Application
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.di.component.ApplicationComponent
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.di.component.DaggerApplicationComponent
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.di.module.NetModule


open class ApplicationClass : Application() {


    public lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .netModule(NetModule())
                .build()
        applicationComponent.inject(this)

    }
}