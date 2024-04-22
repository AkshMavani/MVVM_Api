package com.example.myapi

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapi.Response.ResponseData

class Adapter(private val mList: List<ResponseData>,val context:Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.textView_country.text=ItemsViewModel.get(position).country
        holder.name1.text=ItemsViewModel.get(position).name
        holder.teo.text=ItemsViewModel.get(position).alpha_two_code
        for (i in ItemsViewModel.get(position).domains){
            holder.domain.text=i.toString()
        }


        for (i in ItemsViewModel[position].web_pages){
            Log.e("TAG", "onBindViewHolder:$i ", )
            holder.itemView.setOnClickListener {
                Log.e("TAG", "onBindViewHolder:$i ", )
                val intent=Intent(context,Activity_WebView::class.java)
                intent.putExtra("URL",i.toString())
                context.startActivity(intent)
            }
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView_country: TextView = itemView.findViewById(R.id.textView_Country)
        val domain: TextView = itemView.findViewById(R.id.textview_Domain)
        val name1: TextView = itemView.findViewById(R.id.textview_Name)
        val teo: TextView = itemView.findViewById(R.id.textview_Two)


    }
}