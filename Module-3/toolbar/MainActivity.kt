package com.example.whatsappclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.tablayoutex.MyAdapter
import com.example.whatsappclone.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import java.util.zip.Inflater

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var toolbar: Toolbar
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var list: MutableList<String>


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        list = ArrayList()

        list.add("alex")
        list.add("pooja")
        list.add("raju")
        list.add("devid")



        //adapter
        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        binding.list2.adapter =adapter




        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)


        viewPager = findViewById(R.id.view)
        setupviewpager()

        tabLayout = findViewById(R.id.tab)
        tabLayout.setupWithViewPager(viewPager)


    }



    private fun setupviewpager()
    {
        var adapter = MyAdapter(supportFragmentManager)
        adapter.myfun("CHAT",ChatFragment())
        adapter.myfun("STATUS",StatusFragment())
        adapter.myfun("CALL",CallFragment())
        viewPager.adapter=adapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.option,menu)//menu inflate



        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.i1 -> {
                // Handle item 1 click
                true
            }
            R.id.i2 -> {
                // Handle item 2 click
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}