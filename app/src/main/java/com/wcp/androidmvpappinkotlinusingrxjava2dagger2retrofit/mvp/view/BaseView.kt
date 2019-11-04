package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.view

interface BaseView {
    fun hideLoading()

    fun showLoading()

    fun loadError(e: Throwable)

    fun loadError(msg: String)
}