package com.example.baby_names

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context,var list: MutableList<Model>):RecyclerView.Adapter<Myview>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design_names,parent,false)
        return Myview(view)
    }

    override fun onBindViewHolder(holder: Myview, position: Int) {
        holder.txt.setText(list.get(position).name)
        holder.txt1.setText(list.get(position).meaning)
    }

    override fun getItemCount(): Int
    {
     return  list.size
    }


    fun fileteredlist(filtedlist: ArrayList<Model>) {

        list = filtedlist

        notifyDataSetChanged()
    }
}

class Myview(Itemview: View):RecyclerView.ViewHolder(Itemview)
{
  var txt : TextView = itemView.findViewById(R.id.name)
  var txt1 : TextView = itemView.findViewById(R.id.meaning)

}
