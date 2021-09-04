package com.myapplication.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.myapplication.model.ListofPostModels
import com.myapplication.R
import com.myapplication.view.PostDetails

class PostListAdapter(
    private val arrayList: List<ListofPostModels>?
) : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.item_post_list,
            viewGroup, false
        )
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listOfPostViewModel = arrayList!![position]
        holder.title.text = listOfPostViewModel.title

        holder.itemView.setOnClickListener {

            val context = holder.itemView.context
            val pass = Intent(context, PostDetails::class.java)
            pass.putExtra("name", listOfPostViewModel.title)
            pass.putExtra("comments", listOfPostViewModel.body)
            context.startActivity(pass)


        }
    }

    override fun getItemCount(): Int {
        return arrayList?.size ?: 0

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.txt_post_title)

    }

}