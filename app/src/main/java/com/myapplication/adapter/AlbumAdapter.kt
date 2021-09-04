package com.myapplication.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.R
import com.myapplication.model.ListofAlbumsModel
import com.myapplication.view.AlbumDetails


class AlbumAdapter(private val arrayList: List<ListofAlbumsModel>?) :
        RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.item_album_list,
                viewGroup, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listofAlbumsModel = arrayList!![position]
        holder.title.text = listofAlbumsModel.title

        holder.itemView.setOnClickListener {

            val context = holder.itemView.context
            val pass = Intent(context, AlbumDetails::class.java)
            pass.putExtra("title", listofAlbumsModel.title)
            context.startActivity(pass)


        }
    }

    override fun getItemCount(): Int {
        return arrayList?.size ?: 0

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.txt_album_title)

    }

}