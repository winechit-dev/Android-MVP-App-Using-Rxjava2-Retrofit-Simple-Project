package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.dataModel

import com.google.gson.annotations.SerializedName

data class PostData (
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String


)