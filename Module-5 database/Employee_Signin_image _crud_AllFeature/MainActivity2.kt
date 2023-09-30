package com.example.employee

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.employee.databinding.ActivityMain2Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity2 : AppCompatActivity()

{
    private lateinit var binding: ActivityMain2Binding

     //var UploadService :UploadService = ApiClient.getapiclient().create(UploadService::class.java)
    lateinit var Myadapter: Myadapter
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            //setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        list = ArrayList()
        binding.recycler.layoutManager = LinearLayoutManager(applicationContext)


        val retrofit = Retrofit.Builder().baseUrl("https://immitigable-weeks.000webhostapp.com/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UploadService::class.java)


        CoroutineScope(Dispatchers.IO).launch {



            var call: Call<List<Model>> = retrofit.getdata()
            call.enqueue(object:Callback<List<Model>>
            {
                override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>)
                {
                    list = response.body() as MutableList<Model>

                    var adapter = Myadapter(applicationContext,list)
                    binding.recycler.adapter=adapter

                }

                override fun onFailure(call: Call<List<Model>>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                }
            })


            // Use the main thread to show the toast
            runOnUiThread {

            }

        }





       /* val UploadService  = ApiClient.getapiclient().create(UploadService::class.java)

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)


        Myadapter = Myadapter(this,list)
        recyclerView.adapter = Myadapter

        val call = UploadService.getdata()
        call.enqueue(object :Callback<List<Model>>{
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                list = response.body() as MutableList<Model>

                var adapter = Myadapter(applicationContext,list)
                binding.recycler.adapter=adapter

            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }
        })









//        list = ArrayList()
//
//        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
//        binding.recycler.layoutManager=layoutManager
//
//        UploadService = ApiClient.getapiclient().create(UploadService::class.java)
//
//
//        var call: Call<List<Model>> = UploadService.getdata()
//        call.enqueue(object: Callback<List<Model>>{
//            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
//
//                var i = Intent(applicationContext,MainActivity2::class.java)
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                startActivity(i)
//            }
//
//            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
//                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
//            }
//
//        })
*/

    }

    override fun onBackPressed() {

        finishAffinity()
    }


}