package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.di.component

import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.ApplicationClass
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.di.module.AppModule
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.di.module.NetModule
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.presenter.LoginPresenter
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.presenter.PostPresenter
import dagger.Component


@Component(modules = [AppModule::class, NetModule::class])
interface ApplicationComponent {

    fun inject(newApplication: ApplicationClass)
    fun inject(mLoginPresenter: LoginPresenter)
    fun inject(mPostPresenter: PostPresenter)

}