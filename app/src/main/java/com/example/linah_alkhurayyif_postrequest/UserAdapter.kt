package com.example.linah_alkhurayyif_postrequest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.users.view.*

class UserAdapter(private val userInfo: ArrayList<UserInfo>): RecyclerView.Adapter<UserAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.users,
                parent,
                false ))}
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = userInfo[position]
        holder.itemView.apply {
            userName.text = user.userName
            userLocation.text = user.userLocation
        }
    }
    override fun getItemCount() = userInfo.size
}