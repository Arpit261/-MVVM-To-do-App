package com.arpit.noteapp.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arpit.noteapp.Model.User
import com.arpit.noteapp.R
import kotlinx.android.synthetic.main.each_row.view.*

class userAdaptor( private val context:Context , private var itemlist:ArrayList<User>) :RecyclerView.Adapter<userAdaptor.userViewHolder>() {






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
     val view =LayoutInflater.from(parent.context).inflate(R.layout.each_row , parent , false)
        return userViewHolder(view)
    }

    override fun getItemCount(): Int {
       return itemlist.size
    }

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
     val text=itemlist[position]
        holder.name.text=text.name
        holder.age.text= text.age.toString()
    }

    fun setdata(itemlist: ArrayList<User>){
        this.itemlist=itemlist
        notifyDataSetChanged()
    }



    class userViewHolder(view:View):RecyclerView.ViewHolder(view)
    {
    val name:TextView=view.findViewById(R.id.name)
        val age :TextView=view.findViewById(R.id.age)
    }
}