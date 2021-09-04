package com.myapplication.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapplication.R
import com.myapplication.adapter.PostListAdapter
import com.myapplication.databinding.PostListFragmentBinding
import com.myapplication.model.ListofPostModels
import com.myapplication.viewmodel.ListOfPostViewModel

import java.util.ArrayList

class PostListFragment(postModelsList: List<ListofPostModels>) : Fragment() {


    private var listofPostModelsList = ArrayList<ListofPostModels>()

    init {
        listofPostModelsList = postModelsList as ArrayList<ListofPostModels>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val postListFragmentBinding = DataBindingUtil.inflate<PostListFragmentBinding>(
            inflater,
            R.layout.post_list_fragment, container, false
        )
        val root = postListFragmentBinding.root
        val listOfPostViewModel = ViewModelProviders.of(this).get(ListOfPostViewModel::class.java)
        postListFragmentBinding.lifecycleOwner = activity
        postListFragmentBinding.postviewmodel = listOfPostViewModel

        val postListAdapter = PostListAdapter(listofPostModelsList)
        val linearLayoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        postListFragmentBinding.postRecycler.layoutManager = linearLayoutManager
        postListFragmentBinding.postRecycler.adapter = postListAdapter

        return root
    }



}
