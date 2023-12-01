package com.example.apexfurniture.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apexfurniture.R
import com.example.apexfurniture.activity.FullScreenActivity
import com.example.apexfurniture.model.CategoryModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso

class CategoryAdapter(var context: Context, var list: MutableList<CategoryModel>):RecyclerView.Adapter<MyCategoryView>()


{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCategoryView {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design_category,parent,false)
        return MyCategoryView(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyCategoryView , position: Int)
    {
        holder.textView.setText(list.get(position).name)
        holder.textView3.setText(list.get(position).price)

        Picasso.get().load(list.get(position).img).into(holder.imageview2)




        holder.itemView.setOnClickListener {


            var intent = Intent(context, FullScreenActivity::class.java)
            intent.putExtra("image", list.get(position).img)
            intent.putExtra("name", list.get(position).name)
            intent.putExtra("desc", list.get(position).description)
            intent.putExtra("price", list.get(position).price)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)

        }
    }
}
class MyCategoryView(Itemview: View): RecyclerView.ViewHolder(Itemview)
{
    var textView: TextView = Itemview.findViewById(R.id.tittle)
    var imageview2: ImageView = Itemview.findViewById(R.id.img)
    var textView3: TextView = Itemview.findViewById(R.id.price)



}