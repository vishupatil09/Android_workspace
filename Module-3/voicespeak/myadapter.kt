package com.example.customlayout
import android.annotation.SuppressLint
import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.shopbuy.R
import java.util.Locale


class MyAdapter(var context:Context,var list: MutableList<Model>) : BaseAdapter(),
    TextToSpeech.OnInitListener {
    lateinit var tts: TextToSpeech
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(position: Int): Any
    {
        return position
    }

    override fun getItemId(position: Int): Long
    {
        return position.toLong()
    }

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var inflater = LayoutInflater.from(context)   //layout inflate
        var view =inflater.inflate(R.layout.design,parent,false)

        var image:ImageView = view.findViewById(R.id.img)
        var txt1:TextView = view.findViewById(R.id.txtname)
        var txt2: Button = view.findViewById(R.id.btn3)

       tts = TextToSpeech(context,this)


        txt2.setOnClickListener {

            tts.speak(txt1.text.toString(),QUEUE_ADD,null)

        }

        //get
        image.setImageResource(list.get(position).image)
        txt1.setText(list.get(position).title)
        txt2.setText(list.get(position).description)

        return view
    }

    override fun onInit(status: Int) {
        tts.setLanguage(Locale.UK)
        tts.setPitch(0.6F)
        tts.setSpeechRate(0.8F)
    }

}
