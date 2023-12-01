package com.example.apexfurniture.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apexfurniture.ApiInterface.ApiInterface
import com.example.apexfurniture.Apiclient.ApiClient
import com.example.apexfurniture.R
import com.example.apexfurniture.adapter.CategoryAdapter
import com.example.apexfurniture.databinding.ActivityCategoryViewBinding
import com.example.apexfurniture.model.CategoryModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryViewBinding
    lateinit var apiInterface: ApiInterface
    lateinit var list:MutableList<CategoryModel>
    lateinit var call: Call<List<CategoryModel>>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var pos = i.getIntExtra("pos",404)

        var layoutManager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext,2)
        binding.recycler.layoutManager=layoutManager

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        list = ArrayList()


        if(pos==0)
        {
            call = apiInterface.living_view()
        }
        if(pos==1)
        {
            call = apiInterface.dining_view()
        }
        if(pos==2)
        {
            call = apiInterface.bedroom_view()
        }
        if(pos==3)
        {
            call = apiInterface.office_view()
        }
        if(pos==4)
        {
            call = apiInterface.outdoor_view()
        }
        if(pos==5)
        {
            call = apiInterface.kids_view()
        }
        if(pos==6)
        {
            call = apiInterface.accent_view()
        }
        if(pos==7)
        {
            call = apiInterface.storage_view()
        }
        if(pos==8)
        {
            call = apiInterface.bathroom_view()
        }
        if(pos==9)
        {
            call = apiInterface.entry_view()
        }
        if(pos==10)
        {
            call = apiInterface.antique_view()
        }






        call.enqueue(object: Callback<List<CategoryModel>>
        {
            override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>)
            {
                list = response.body() as MutableList<CategoryModel>

                var adapter = CategoryAdapter(applicationContext,list)
                binding.recycler.adapter=adapter

            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable)
            {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }
        })
    }

}