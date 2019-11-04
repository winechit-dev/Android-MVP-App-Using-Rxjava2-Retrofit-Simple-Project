package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.activities

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.BaseActivity
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.R
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.adapters.PostAdapter
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.dataModel.PostData
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.presenter.PostPresenter
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.view.PostView
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : BaseActivity(), PostView {
    var postPresenter: PostPresenter?=null


    override fun setLayout(): Int {

        return R.layout.activity_post;
    }

    override fun init(savedInstanceState: Bundle?) {
        //  postPresenter.getAllPosts()
        getPresenter()?.let {
            it.getAllPosts()
        }
    }

    fun getPresenter(): PostPresenter?{
        postPresenter = PostPresenter(this, application)
        return postPresenter
    }

    override fun onStartScreen() {
    }

    override fun stopScreen() {
        postPresenter?.let {
            postPresenter!!.unbindView()
            postPresenter = null
        }

    }





    override fun showAllPosts(postListModel: List<PostData>) {

        Log.d("Response", "" + postListModel)
        rv_post_list.layoutManager = LinearLayoutManager(this)
        rv_post_list.adapter = PostAdapter(postListModel, this)
    }


}
