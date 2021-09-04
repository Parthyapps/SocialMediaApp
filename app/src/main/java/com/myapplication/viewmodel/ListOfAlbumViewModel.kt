package com.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.myapplication.model.ListofAlbumsModel
import com.myapplication.rest.ApiInterface
import com.myapplication.rest.RetrofitSingleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListOfAlbumViewModel : ViewModel(){

    private var albumdata: MutableLiveData<List<ListofAlbumsModel>>? = null

    fun getAlbumdata(): MutableLiveData<List<ListofAlbumsModel>> {

        if (albumdata == null) {
            albumdata = MutableLiveData()
            GetAlbumList()
        }

        return albumdata as MutableLiveData<List<ListofAlbumsModel>>
    }


    private fun GetAlbumList() {

        val apiInterface = RetrofitSingleton.getClient().create(ApiInterface::class.java)

        val call = apiInterface.albumList
        call.enqueue(object : Callback<List<ListofAlbumsModel>> {
            override fun onResponse(
                call: Call<List<ListofAlbumsModel>>,
                response: Response<List<ListofAlbumsModel>>
            ) {

                Log.e("album_data", Gson().toJson(response.body()))
                albumdata!!.value = response.body()


            }

            override fun onFailure(call: Call<List<ListofAlbumsModel>>, t: Throwable) {

                Log.e("albumerror", t.message)

            }
        })


    }

}
