package com.example.baby_names

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    lateinit var spin1: Spinner
    lateinit var spin2: Spinner
    lateinit var spin3: Spinner
    lateinit var apiInterface: Apiinterface
    lateinit var searchView: SearchView
    lateinit var countTextView: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<Model>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        spin1 = view.findViewById(R.id.spin1)
        spin2 = view.findViewById(R.id.spin2)
        spin3 = view.findViewById(R.id.spin3)
        searchView = view.findViewById(R.id.search)
        countTextView = view.findViewById(R.id.count)
        recyclerView = view.findViewById(R.id.recycler)


        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        apiInterface = ApiClient.getapiclient()!!.create(Apiinterface::class.java)
        list = ArrayList()

        var call = apiInterface.viewnames()
        call.enqueue(object : Callback<List<Model>>{
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>)
            {
                list = response.body() as MutableList<Model>
                var adapter = MyAdapter(requireContext(), list,)
                recyclerView.adapter = adapter


            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                Toast.makeText(requireContext(), "No Internet", Toast.LENGTH_LONG).show()

            }
        })

        var gender = arrayOf("Select Any","Male","Female")
        var rashi = arrayOf("Select Any","Mesh",        // Aries
            "Vrishabha",   // Taurus
            "Mithuna",     // Gemini
            "Karka",       // Cancer
            "Simha",       // Leo
            "Kanya",       // Virgo
            "Tula",        // Libra
            "Vrishchika",  // Scorpio
            "Dhanu",       // Sagittarius
            "Makara",      // Capricorn
            "Kumbha",      // Aquarius
            "Meena"        // Pisces
        )
        var religion = arrayOf("Select Any",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        )


        val adapter1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item,gender)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin1.adapter = adapter1


        val adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item,rashi)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin2.adapter = adapter2

        val adapter3 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item,religion)
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin3.adapter = adapter3

        spin1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = gender[position]
                if (position ==0){
                    list
                }
                // Handle the selected item
                else{
                    filter(selectedItem)
                }
                //Toast.makeText(requireContext(), "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        spin2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = rashi[position]
                if (position ==0){
                    list
                }
                else{
                    filter(selectedItem)

                }
               // Toast.makeText(requireContext(), "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        spin3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = religion[position]
                // Handle the selected item
                if (position ==0){
                    list
                }
                else{
                    filter(selectedItem)
                }
                    //filter(selectedItem)

                //Toast.makeText(requireContext(), "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        // Inflate the layout for this fragment
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Perform search logic here
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Perform search logic here
                filter(newText.orEmpty())
                return true
            }
        })

        return view
    }
    private fun filter(text: String) {

        var filtedlist = ArrayList<Model>()

        for (item in list)
        {
            if (item.name!!.toLowerCase().contains(text.toLowerCase()))
            {
                filtedlist.add(item)
            }
            else{
                list
            }
        }
        if (filtedlist.isNullOrEmpty()){

            Toast.makeText(requireContext(), "no found", Toast.LENGTH_SHORT).show()
        }
        else{
            var adapter = MyAdapter(requireContext(),list)
            recyclerView.adapter = adapter

            adapter.fileteredlist(filtedlist)
        }
    }


}