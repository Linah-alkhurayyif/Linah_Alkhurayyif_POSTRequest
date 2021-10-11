package com.example.linah_alkhurayyif_postrequest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
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
            userId.text="User Id: ${user.id}"
            del.setOnClickListener {
                val intent = Intent(context, Del_User::class.java)
                intent.putExtra("User_Id", user.id)
                context.startActivity(intent)
            }
            update.setOnClickListener {
                val intent = Intent(context, Upd_User::class.java)
                intent.putExtra("User_Id", user.id)
                intent.putExtra("User_Name",user.userName)
                intent.putExtra("User_Location",user.userLocation)
                context.startActivity(intent)
            }
        }
    }
    override fun getItemCount() = userInfo.size

}