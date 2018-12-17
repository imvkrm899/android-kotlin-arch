package com.kotlin.androidproject.kotlinassignmentproj.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kotlin.androidproject.kotlinassignmentproj.R
import com.kotlin.androidproject.kotlinassignmentproj.adapter.DisplayAdapter.BindingHolder
import com.kotlin.androidproject.kotlinassignmentproj.roomDB.User

class DisplayAdapter constructor(private var context: Context, private var userList: List<User>) : RecyclerView.Adapter<BindingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        return BindingHolder(LayoutInflater.from(context).inflate(R.layout.row_activty_display, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        holder.mUserName?.text = userList.get(position).name
        holder.mUserEmail?.text = userList.get(position).email
    }

    class BindingHolder constructor(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var mUserName: TextView? = itemView?.findViewById(R.id.textView_user_name)
        var mUserEmail: TextView? = itemView?.findViewById(R.id.textView_user_email)
    }

}