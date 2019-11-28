package com.example.roomexample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomexample.R
import com.example.roomexample.room.UserData

class UserAdapter :RecyclerView.Adapter<UserAdapter.ViewHolder>(){
private var data= emptyList<UserData>()
var listener:((UserData)->Unit)?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user=data[position]
        holder.firstName.text="${user.firstName }${ user.uid}"
        holder.lastName.text=user.lastNmae
        holder.itemView.setOnClickListener { listener?.invoke(user) }
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
      val firstName=view.findViewById<TextView>(R.id.firstName)
      val lastName=view.findViewById<TextView>(R.id.lastName)
    }

    fun setItems(list: List<UserData>){
        data=list
        notifyDataSetChanged()
    }

}