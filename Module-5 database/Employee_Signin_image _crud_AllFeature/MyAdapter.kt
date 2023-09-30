package com.example.employee

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Myadapter(var context: Context, var list: MutableList<Model>):RecyclerView.Adapter<MyView>()


{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design,parent,false)
        return MyView(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView , position: Int)
    {



        holder.textView.setText(list.get(position).emp_name)
        holder.textView2.setText(list.get(position).emp_mobile)
        holder.textView3.setText(list.get(position).emp_email)
        Picasso.get().load(list.get(position).img).into(holder.Img)


       // var UploadService = ApiClient.getapiclient().create(UploadService::class.java)
        val retrofit = Retrofit.Builder().baseUrl("https://immitigable-weeks.000webhostapp.com/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UploadService::class.java)


        holder.itemView.setOnClickListener {

            var alertDialog = AlertDialog.Builder(holder.itemView.context)
            alertDialog.setTitle("Select Operation?")
            alertDialog.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->

                var i = Intent(context,UpdateActivity::class.java)
                i.putExtra("id",list.get(position).id)
                i.putExtra("emp_name",list.get(position).emp_name)
                i.putExtra("emp_mobile",list.get(position).emp_mobile)
                i.putExtra("emp_email",list.get(position).emp_email)
                i.putExtra("emp_pass",list.get(position).emp_pass)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(i)
            })
            alertDialog.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(context,""+list.get(position).id,Toast.LENGTH_LONG).show()
                var call: Call<Void>? =  retrofit.deletedata(list.get(position).id)

                call!!.enqueue(object: Callback<Void?> { override fun onResponse(call: Call<Void?>, response: Response<Void?>) {

                    var i = Intent(context,MainActivity2::class.java)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(i) }

                    override fun onFailure(call: Call<Void?>, t: Throwable) {
                        Toast.makeText(context,"No Internet",Toast.LENGTH_LONG).show() }
                })


            })
            alertDialog.show()

        }

    }
}
class MyView(Itemview:View):RecyclerView.ViewHolder(Itemview)
{
    var textView: TextView = Itemview.findViewById(R.id.txt1)
    var textView2: TextView = Itemview.findViewById(R.id.txt2)
    var textView3: TextView = Itemview.findViewById(R.id.txt3)
    var Img : ImageView = Itemview.findViewById(R.id.img)



}