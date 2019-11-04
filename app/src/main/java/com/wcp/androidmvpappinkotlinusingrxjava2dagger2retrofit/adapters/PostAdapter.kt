package com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.R
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.adapters.PostAdapter.*
import com.wcp.androidmvpappinkotlinusingrxjava2dagger2retrofit.mvp.dataModel.PostData
import kotlinx.android.synthetic.main.post_list_item.view.*

class PostAdapter(val postList: List<PostData>, val context: Context) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.post_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.itemView.tv_post_title.text = postList.get(position).title
        holder?.itemView.tv_post_body.text = postList.get(position).body
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }


}