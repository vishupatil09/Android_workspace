package com.example.apexfurniture.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apexfurniture.ApiInterface.ApiInterface
import com.example.apexfurniture.Apiclient.ApiClient
import com.example.apexfurniture.R
import com.example.apexfurniture.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiinterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnRegister.setOnClickListener {

            val name = binding.edt1.text.toString()
            val email = binding.edt2.text.toString()
            val phone = binding.edt3.text.toString()
            val pass = binding.edt4.text.toString()

            if (pass.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Please Enter Proper Password",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                if (name.isEmpty()) {
                    binding.edt1.error = "Please Enter Proper FirstName"
                }  else if (email.isEmpty()) {
                    binding.edt2.error = "Please Enter Proper Email"
                } else if (phone.length != 10) {
                    binding.edt3.error = "Please Enter Proper Phone Number"
                } else {
                    apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

                    val registercall: Call<Void> =
                        apiinterface.registerdetail(name, email, phone, pass)
                    registercall.enqueue(object : Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {

                            startActivity(Intent(applicationContext, LoginActivity::class.java))
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG)
                                .show()
                        }
                    })
                }


            }

        }
        binding.Logintxt.setOnClickListener {
            startActivity(Intent(applicationContext, LoginActivity::class.java))


        }

    }
}