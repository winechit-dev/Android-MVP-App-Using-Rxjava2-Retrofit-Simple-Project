package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.network


import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.dataModel.PostData
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.endpoint.Endpoints
import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkApi {
    @GET(Endpoints.posts)
    fun getAllPosts(): Observable<List<PostData>>

}