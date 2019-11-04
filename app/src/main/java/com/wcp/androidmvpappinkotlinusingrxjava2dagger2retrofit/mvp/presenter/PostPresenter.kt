package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.presenter

import android.app.Application
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.ApplicationClass
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.view.PostView
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.network.INetworkApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import javax.inject.Inject

class PostPresenter(var postView: PostView, var applicationComponent: Application) : BasePresenter<PostView>(postView) {

    @Inject
    lateinit var mNetworkApi: INetworkApi

    init {
        (applicationComponent as ApplicationClass).applicationComponent.inject(this)
    }

    fun getAllPosts() {


        var view=view()

        view?.let {
            it.showLoading()
            var allPosts = mNetworkApi.getAllPosts()
            addDisposable(allPosts.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        view?.let {
                            it.hideLoading()
                            postView.showAllPosts(result)

                        }
                    },
                    { error ->
                        view?.let {
                            it.hideLoading()
                        }
                    }
                ) ) }

        var allPosts = mNetworkApi.getAllPosts()
        allPosts.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                postView.showAllPosts(it)
                postView.hideLoading()
            }

    }


}
