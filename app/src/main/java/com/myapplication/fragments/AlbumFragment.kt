package com.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager


import com.myapplication.R
import com.myapplication.adapter.AlbumAdapter
import com.myapplication.databinding.AlbumListFragmentBinding
import com.myapplication.model.ListofAlbumsModel
import com.myapplication.rest.MyProgressDialog
import com.myapplication.viewmodel.ListOfAlbumViewModel

import java.util.ArrayList

class AlbumFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val myProgressDialog = activity?.let { MyProgressDialog(it) }
        myProgressDialog!!.setCancelable(true)
        myProgressDialog.show()

        val albumListFragmentBinding = DataBindingUtil.inflate<AlbumListFragmentBinding>(
            inflater,
            R.layout.album_list_fragment, container, false
        )
        val root = albumListFragmentBinding.root
        val listOfAlbumViewModel = ViewModelProviders.of(this).get(ListOfAlbumViewModel::class.java)
        albumListFragmentBinding.lifecycleOwner = activity
        albumListFragmentBinding.albumviewmodel = listOfAlbumViewModel

        listOfAlbumViewModel.getAlbumdata().observe(this, Observer { listOfAlbumViewModel ->
            myProgressDialog.dismiss()

            val postListAdapter = AlbumAdapter(listOfAlbumViewModel)
            val linearLayoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            albumListFragmentBinding.albumRecyler.layoutManager = linearLayoutManager
            albumListFragmentBinding.albumRecyler.adapter = postListAdapter

        })


        return root
    }
}
