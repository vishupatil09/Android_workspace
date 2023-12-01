package com.example.apexfurniture.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apexfurniture.ApiInterface.ApiInterface
import com.example.apexfurniture.Apiclient.ApiClient
import com.example.apexfurniture.databinding.ActivityLoginBinding
import com.example.apexfurniture.model.RegisterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity()

{

    private lateinit var binding: ActivityLoginBinding
    private lateinit var apiinterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?)

    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("user_session", false) &&
            sharedPreferences.getString("mob", "")!!.isNotEmpty()) {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }
        binding.btnLogin.setOnClickListener {

            val phone = binding.edt3.text.toString()
            val pass = binding.edt4.text.toString()

            apiinterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)
            val call: Call<RegisterModel> = apiinterface.logindata(phone,pass)
            call.enqueue(object: Callback<RegisterModel> {
                override fun onResponse(
                    call: Call<RegisterModel>,
                    response: Response<RegisterModel>, )
                {
                    sharedPreferences.edit().putString("mob",phone).apply()
                     sharedPreferences.edit().putBoolean("user_session",true).apply()

                    Toast.makeText(applicationContext,"Success", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext, DashboardActivity::class.java))

                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Fail", Toast.LENGTH_LONG).show()

                }
            })
        }



        binding.btnSignin.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity::class.java))

        }

    }

    override fun onBackPressed() {
        finishAffinity()
    }


}