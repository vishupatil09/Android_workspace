package com.example.apexfurniture.activity


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apexfurniture.ApiInterface.ApiInterface
import com.example.apexfurniture.Apiclient.ApiClient
import com.example.apexfurniture.R
import com.example.apexfurniture.adapter.DashboardAdapter
import com.example.apexfurniture.databinding.ActivityDashboardBinding
import com.example.apexfurniture.model.DashboardModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DashboardActivity : AppCompatActivity()
{
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityDashboardBinding
    lateinit var apiInterface: ApiInterface
    lateinit var list: MutableList<DashboardModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        list = ArrayList()

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        Toast.makeText(applicationContext, "Welcome " + sharedPreferences.getString("mob", ""),
            Toast.LENGTH_LONG
        ).show()

        var layoutManager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext,2)
        binding.recycler.layoutManager = layoutManager

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        list = ArrayList()

        var call: Call<List<DashboardModel>> = apiInterface.dashboard_viewdata()
        call.enqueue(object : Callback<List<DashboardModel>> {
            override fun onResponse(
                call: Call<List<DashboardModel>>,
                response: Response<List<DashboardModel>>
            ) {
                list = response.body() as MutableList<DashboardModel>

               var adapter = DashboardAdapter(applicationContext, list,)
                binding.recycler.adapter = adapter

            }

            override fun onFailure(call: Call<List<DashboardModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        var inflater = menuInflater
        inflater.inflate(R.menu.option,menu)
        var adapter = DashboardAdapter(applicationContext, list,)
        binding.recycler.adapter = adapter

        var searchitem :MenuItem= menu!!.findItem(R.id.search)
        var searchView:SearchView= searchitem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                if (newText != null) {
                    var adapter = DashboardAdapter(applicationContext, list)
                    binding.recycler.adapter = adapter

                    filter(newText.orEmpty())
                }
                return true
            }
        })

       //var wish :MenuItem = menu.findItem(R.id.wishlist)



        return true
    }

    private fun filter(text: String) {

        var filtedlist = ArrayList<DashboardModel>()

        for (item in list)
        {
            if (item.p_type!!.toLowerCase().contains(text.toLowerCase()))
            {
                filtedlist.add(item)
            }
        }
            if (filtedlist.isNullOrEmpty()){
                Toast.makeText(applicationContext, "no found", Toast.LENGTH_SHORT).show()
            }
        else{
               var adapter = DashboardAdapter(applicationContext,list)
                binding.recycler.adapter = adapter

                adapter.fileteredlist(filtedlist)
            }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {


        when(item.itemId)
        {
            R.id.wishlist->{
                startActivity(Intent(applicationContext,WishlistActivity::class.java))

            }
            R.id.cart->{
                startActivity(Intent(applicationContext,CartAcivity::class.java))

            }
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                startActivity(Intent(applicationContext,LoginActivity::class.java))
                finish()
            }
        }
        return true


    }
    override fun onBackPressed()
    {
        finishAffinity()
    }



}
