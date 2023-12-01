package com.example.apexfurniture.activity

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apexfurniture.ApiInterface.ApiInterface
import com.example.apexfurniture.Apiclient.ApiClient
import com.example.apexfurniture.adapter.CartAdapter
import com.example.apexfurniture.databinding.ActivityCartBinding
import com.example.apexfurniture.model.CartModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartAcivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCartBinding
    private lateinit var mutableList: MutableList<CartModel>
    lateinit var apiInterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences
    lateinit var mAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        val view = binding.root
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Setting up ActionBar
        binding.mToolbar.title = "My Cart"
        setSupportActionBar(binding.mToolbar)
        binding.mToolbar.setNavigationOnClickListener {
            super.finish()


        }
        setContentView(view)
        // Setting up activity window


        mutableList = ArrayList()
        mAdapter = CartAdapter(applicationContext, mutableList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        //sharedprefrence
        sharedPreferences = getSharedPreferences("user_session", MODE_PRIVATE)
        val mob = sharedPreferences.getString("mob", "")


        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        val call = apiInterface.cartViewData(mob)
        call.enqueue(object : Callback<List<CartModel>> {
            override fun onResponse(
                call: Call<List<CartModel>>,
                response: Response<List<CartModel>>
            ) {
                mutableList = response.body() as MutableList<CartModel>
                mAdapter = CartAdapter(applicationContext, mutableList)
                //binding.progressIndicator.visibility = View.GONE
                binding.recyclerView.adapter = mAdapter
            }

            override fun onFailure(call: Call<List<CartModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }
        })

    }


}