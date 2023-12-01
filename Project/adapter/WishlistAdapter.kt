package com.example.apexfurniture.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apexfurniture.ApiInterface.ApiInterface
import com.example.apexfurniture.Apiclient.ApiClient
import com.example.apexfurniture.R
import com.example.apexfurniture.activity.FullScreenActivity
import com.example.apexfurniture.model.CartModel
import com.example.apexfurniture.model.WishlistModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WishlistAdapter(var context: Context?, var mutableList: MutableList<WishlistModel>) : RecyclerView.Adapter<WishViewHolder>() {

    lateinit var apiInterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences
//
//    companion object {
//        lateinit var itemClickListener: ItemClickListener
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.wish_design, parent, false
        )
        return WishViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: WishViewHolder, @SuppressLint("RecyclerView") position: Int) {

        sharedPreferences = context!!
            .getSharedPreferences("user_session", Context.MODE_PRIVATE)
        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        val myId = mutableList[position].id
        val giftName = mutableList[position].name
        val giftPrice = mutableList[position].price
        val giftDesc = mutableList[position].description
        val giftImage = mutableList[position].img

        holder.textView1.text = giftName
        holder.textView2.text = giftPrice
        Picasso.get().load(giftImage).into(holder.imageView)

        holder.itemView.setOnClickListener {
            var intent = Intent(context, FullScreenActivity::class.java)
            intent.putExtra("image", giftImage)
            intent.putExtra("name", giftName)
            intent.putExtra("desc", giftDesc)
            intent.putExtra("price", giftPrice)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context!!.startActivity(intent)
        }

        holder.removeFromwishlistBtn.setOnClickListener {
            val call = apiInterface.deleteWishList(myId)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    mutableList.removeAt(position)
                    //itemClickListener.onItemClick(holder.adapterPosition, it)
                    Toast.makeText(context, "Removed from wishlist ", Toast.LENGTH_SHORT).show()

                    (holder.itemView.context as Activity).recreate()


                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                }
            })
        }

        holder.addToCartBtn.setOnClickListener {

            val mob = sharedPreferences.getString("mob", "")

            val call = apiInterface.addtoCart(
                giftName, giftDesc,
                giftPrice, giftImage, mob
            )
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
    }
    interface ItemClickListener {
        fun onItemClick(position: Int, view: View)
    }

//    fun setOnItemClickListener(myClickListener: ItemClickListener) {
//        itemClickListener = myClickListener
//    }
//}

class WishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView
    val textView1: MaterialTextView
    val textView2: MaterialTextView
    val addToCartBtn: MaterialButton
    val removeFromwishlistBtn: MaterialButton

    init {
        imageView = itemView.findViewById(R.id.imageView)
        textView1 = itemView.findViewById(R.id.tvName)
        textView2 = itemView.findViewById(R.id.tvPrice)
        addToCartBtn = itemView.findViewById(R.id.addToCartBtn)
        removeFromwishlistBtn = itemView.findViewById(R.id.removeFromWishlistBtn)
    }
}