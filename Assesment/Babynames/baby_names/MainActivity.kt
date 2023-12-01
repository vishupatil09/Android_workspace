package com.example.baby_names

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity()
{
    lateinit var drower: DrawerLayout
    lateinit var nav: NavigationView
    lateinit var toolbar : MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        drower = findViewById(R.id.drawer)
        nav = findViewById(R.id.nav)
        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        var Adt = ActionBarDrawerToggle(this,drower,toolbar,R.string.open_drawer,R.string.close_drawer)

        drower.addDrawerListener(Adt)
        Adt.syncState()
        loadfragment(HomeFragment())



        nav.setNavigationItemSelectedListener {item->

            when(item.itemId){

                R.id.home ->{
                    loadfragment(HomeFragment())
                    Toast.makeText(applicationContext, ""+item, Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.rashi->{

                    loadfragment( RashiFragment())
                    Toast.makeText(applicationContext, ""+item, Toast.LENGTH_SHORT).show()

                    true }
                R.id.religion->{
                    loadfragment(ReligionFragment())
                    Toast.makeText(applicationContext, ""+item, Toast.LENGTH_SHORT).show()

                    true }
                R.id.favorite->{
                    loadfragment(FavoriteFragment())
                    Toast.makeText(applicationContext, ""+item, Toast.LENGTH_SHORT).show()

                    true }
                R.id.developer->{
                    loadfragment(DeveloperFragment())
                    Toast.makeText(applicationContext, ""+item.title, Toast.LENGTH_SHORT).show()

                    true }

                else-> {
                     false
                }

            }
            drower.closeDrawer(GravityCompat.START)
            true
        }

    }

    private fun loadfragment(fragment: Fragment) {

        var frag =supportFragmentManager
        var ft = frag.beginTransaction()

        ft.add(R.id.containt,fragment)
        ft.commit()
    }

    override fun onBackPressed() {

        if (drower.isDrawerOpen(GravityCompat.START)){
            drower.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.favorite-> startActivity(Intent(applicationContext,MainActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }


}