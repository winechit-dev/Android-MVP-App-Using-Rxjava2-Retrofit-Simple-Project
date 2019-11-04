package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.view

import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.dataModel.PostData

interface PostView : BaseView{
    fun showAllPosts(postList: List<PostData>)
}