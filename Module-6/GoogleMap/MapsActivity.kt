package com.example.googlemap

import android.Manifest
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.googlemap.databinding.ActivityMapsBinding
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import java.io.IOException

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    lateinit var manager: LocationManager
    var lattitude=0.0
    var longitude=0.0
    lateinit var location: Location
    private var isMapTypeOptionsVisible = false
    lateinit var binding: ActivityMapsBinding



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.search.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // on below line we are getting the
                // location name from search view.
                val location = binding.search.getQuery().toString()

                // below line is to create a list of address
                // where we will store the list of all address.
                var addressList: List<Address>? = null

                // checking if the entered location is null or not.
                if (location != null || location == "") {
                    // on below line we are creating and initializing a geo coder.
                    val geocoder = Geocoder(this@MapsActivity)
                    try {
                        // on below line we are getting location from the
                        // location name and adding that location to address list.
                        addressList = geocoder.getFromLocationName(location, 1)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                    // on below line we are getting the location
                    // from our list a first position.
                    val address = addressList!![0]

                    // on below line we are creating a variable for our location
                    // where we will add our locations latitude and longitude.
                    val latLng = LatLng(address.latitude, address.longitude)

                    // on below line we are adding marker to that position.
                    mMap!!.addMarker(MarkerOptions().position(latLng).title(location))

                    // below line is to animate camera to that position.
                    mMap!!.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.fab.setOnClickListener { toggleMapTypeOptions() }


        binding.mapTypeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rd1 -> setMapType(GoogleMap.MAP_TYPE_NORMAL)
                R.id.rd2 -> setMapType(GoogleMap.MAP_TYPE_SATELLITE)
                R.id.rd3 -> setMapType(GoogleMap.MAP_TYPE_HYBRID)
                R.id.rd4 -> setMapType(GoogleMap.MAP_TYPE_TERRAIN)
                else -> {


                }
            }
        }



        manager = getSystemService(LOCATION_SERVICE) as LocationManager

        if(!manager.isProviderEnabled(LocationManager.GPS_PROVIDER))
        {
            Toast.makeText(applicationContext,"GPS is not working", Toast.LENGTH_LONG).show()
        }
        else if(!manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
        {
            Toast.makeText(applicationContext,"Network is not working", Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(applicationContext,"Fetching Location", Toast.LENGTH_LONG).show()

        }


        var locationlistener: LocationListener = object : LocationListener
        {
            override fun onLocationChanged(location: Location)
            {

                lattitude = location.latitude
                longitude = location.longitude

            }
        }
        if(manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
        {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0.0F,locationlistener)
        }

        location = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)!!
        if(location!=null)
        {
            lattitude = location.getLatitude()
            longitude = location.getLongitude()
            Toast.makeText(applicationContext, ""+location.getLatitude(), Toast.LENGTH_SHORT).show()
        }

    }



    private fun toggleMapTypeOptions() {
        if (isMapTypeOptionsVisible) {
            binding.mapTypeRadioGroup.visibility = View.GONE
        } else {
            binding.mapTypeRadioGroup.visibility = View.VISIBLE
        }
        isMapTypeOptionsVisible = !isMapTypeOptionsVisible
    }
    private fun setMapType(mapTypeNormal: Int) {

        mMap.mapType = mapTypeNormal
        toggleMapTypeOptions()

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap)
    {
        mMap = googleMap
        binding.location.setOnClickListener {

            // Add a marker in Sydney and move the camera
            val Mylocation = LatLng(lattitude, longitude)
            mMap.addMarker(MarkerOptions().position(Mylocation).title("Marker at your place"))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Mylocation,10f))

        }

    }
}