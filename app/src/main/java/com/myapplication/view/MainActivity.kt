package com.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.ListFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.myapplication.R
import com.myapplication.databinding.ActivityMainBinding
import com.myapplication.fragments.AlbumFragment
import com.myapplication.fragments.PostListFragment
import com.myapplication.model.ListofAlbumsModel
import com.myapplication.model.ListofPostModels
import com.myapplication.rest.MyProgressDialog
import com.myapplication.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    private var postModelsList: List<ListofPostModels>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val myProgressDialog = MyProgressDialog(this)
        myProgressDialog.setCancelable(true)
        myProgressDialog.show()

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.lifecycleOwner = this
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainBinding.mainviewmodel = mainViewModel


        mainViewModel.getData().observe(this, Observer { listofPostModels ->
            postModelsList = listofPostModels
            myProgressDialog.dismiss()

            val post_frag = PostListFragment(listofPostModels)
            replaceFragment(post_frag)
        })

        mainBinding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        val post_frag = PostListFragment(postModelsList!!)
                        replaceFragment(post_frag)
                    }
                    1 -> {
                        val album_frag = AlbumFragment()
                        replaceFragment(album_frag)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }


    private fun replaceFragment(destFragment: Fragment) {
        val fragmentManager = this.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, destFragment)
        fragmentTransaction.commit()
    }
}
