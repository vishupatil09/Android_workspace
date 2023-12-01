package com.example.apexfurniture.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apexfurniture.ApiInterface.ApiInterface
import com.example.apexfurniture.Apiclient.ApiClient
import com.example.apexfurniture.R
import com.example.apexfurniture.databinding.ActivityFullScreenBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.jar.Attributes

class FullScreenActivity : AppCompatActivity() { private lateinit var binding: ActivityFullScreenBinding
    private lateinit var apiInterface: ApiInterface
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        binding.mToolbar.setNavigationOnClickListener {
            // Handle the navigation icon click here
            onBackPressed() // For example, go back when the navigation icon is clicked
        }

        //setSupportActionBar(binding.mToolbar)
        val mob = sharedPreferences.getString("mob", "1")
        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        val intent = intent
        val image = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        val Description = intent.getStringExtra("desc")
        val price = intent.getStringExtra("price")

        binding.mToolbar.setTitle(name+"  Details")


        Picasso.get().load(image).into(binding.img)
        binding.Name.text = name
        binding.Description.text = Description
        binding.Price.text = price

        binding.wishListButton.setOnClickListener {

            val call = apiInterface.addtowishlist(name, Description, price, image, mob)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "Added to wishlist", Toast.LENGTH_SHORT)
                        .show()

                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Wishlist Failed", Toast.LENGTH_SHORT).show()
                }
            })


        }
        binding.cartButton.setOnClickListener {


            val call = apiInterface.addtoCart(name, Description, price, image, mob)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "Added to cart", Toast.LENGTH_SHORT)
                        .show()

                    startActivity(Intent(applicationContext,CartAcivity::class.java))

                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "cart Failed", Toast.LENGTH_SHORT).show()
                }
            })


            binding.mToolbar.setOnClickListener{

            }



        }

    }
}