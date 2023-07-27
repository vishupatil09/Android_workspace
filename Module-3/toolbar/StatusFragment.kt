package com.example.whatsappclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.listviewex.MyAdapter2
import com.example.tablayoutex.Model
import com.example.whatsappclone.databinding.FragmentChatBinding

class StatusFragment : Fragment() {
    private var _binding: FragmentChatBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!


    lateinit var list: MutableList<Model>
    lateinit var listView: ListView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //var view = inflater.inflate(R.layout.fragment_chat, container, false)
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        val view = binding.root
        listView = view.findViewById(R.id.list)

        list = ArrayList()


        list.add(Model(R.drawable.male, "Devid", "HIII"))
        list.add(Model(R.drawable.female, "alexa", "can you hear me.!!!!"))
        list.add(Model(R.drawable.male, "karan", "HIII"))
        list.add(Model(R.drawable.female, "Kiran", "can you hear me.!!!!"))
        list.add(Model(R.drawable.male, "Raju", "HIII"))
        list.add(Model(R.drawable.female, "Pooja", "can you hear me.!!!!"))
        list.add(Model(R.drawable.male, "Shyam", "HIII"))
        list.add(Model(R.drawable.female, "Hina", "can you hear me.!!!!"))
        list.add(Model(R.drawable.male, "Akshay", "HIII"))
        list.add(Model(R.drawable.female, "Apeksha", "can you hear me.!!!!"))


        var adapter = MyAdapter2(requireActivity(), list)
        listView.adapter = adapter


        return view
    }


}