package com.example.apexfurniture.activity

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apexfurniture.ApiInterface.ApiInterface
import com.example.apexfurniture.Apiclient.ApiClient
import com.example.apexfurniture.adapter.WishlistAdapter
import com.example.apexfurniture.databinding.ActivityWishListBinding
import com.example.apexfurniture.model.WishlistModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WishlistActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityWishListBinding
    private lateinit var mutableList: MutableList<WishlistModel>
    lateinit var apiInterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences
    lateinit var mAdapter: WishlistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWishListBinding.inflate(layoutInflater)
        val view = binding.root
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Setting up ActionBar
        binding.mToolbar.title = "My Wishlist"
        setSupportActionBar(binding.mToolbar)
        binding.mToolbar.setNavigationOnClickListener {
            super.finish()


        }
        setContentView(view)

        mutableList = ArrayList()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        //sharedprefrence
        sharedPreferences = getSharedPreferences("user_session", MODE_PRIVATE)
        val mob = sharedPreferences.getString("mob", "")
        Toast.makeText(applicationContext,""+mob,Toast.LENGTH_SHORT).show()

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        val call = apiInterface.wishlistViewData(mob)
        call.enqueue(object : Callback<List<WishlistModel>> {
            override fun onResponse(
                call: Call<List<WishlistModel>>,
                response: Response<List<WishlistModel>>
            ) {
                mutableList = response.body() as MutableList<WishlistModel>
                //Toast.makeText(applicationContext,""+mutableList.size,Toast.LENGTH_SHORT).show()
             mAdapter = WishlistAdapter(applicationContext, mutableList)
                //binding.progressIndicator.visibility = View.GONE
                binding.recyclerView.adapter = mAdapter
            }

            override fun onFailure(call: Call<List<WishlistModel>>, t: Throwable) {
                Toast.makeText(this@WishlistActivity, "Failed", Toast.LENGTH_SHORT).show()
            }
        })

    }


}