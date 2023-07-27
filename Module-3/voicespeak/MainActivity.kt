package com.example.shopbuy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import com.example.customlayout.Model
import com.example.customlayout.MyAdapter
import com.example.shopbuy.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    lateinit var list:MutableList<Model>
    lateinit var button: Button
    lateinit var textView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)






        list = ArrayList()

        //set
        list.add(Model(R.drawable.caret,"Caret","Voice"))
        list.add(Model(R.drawable.chilly,"Chilly","Voice"))
        list.add(Model(R.drawable.tamoto,"Tamato","Voice"))
        list.add(Model(R.drawable.mango,"Mango","Voice"))
        list.add(Model(R.drawable.beet,"Beetroot ","Voice"))
        list.add(Model(R.drawable.pineapple,"Pineapple ","Voice"))
        list.add(Model(R.drawable.strowberry,"Strawberry ","Voice"))


        var adapter = MyAdapter(applicationContext,list)
        binding.gridview.adapter = adapter



    }



}