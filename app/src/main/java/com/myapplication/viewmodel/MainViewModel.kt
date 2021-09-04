package com.myapplication.viewmodel

import android.util.Log

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.google.gson.Gson
import com.myapplication.model.ListofAlbumsModel
import com.myapplication.model.ListofPostModels
import com.myapplication.rest.ApiInterface
import com.myapplication.rest.RetrofitSingleton

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {


    private var data: MutableLiveData<List<ListofPostModels>>? = null


    fun getData(): MutableLiveData<List<ListofPostModels>> {

        if (data == null) {
            data = MutableLiveData()
            GetPostList()

        }
        return data as MutableLiveData<List<ListofPostModels>>
    }


    private fun GetPostList() {

        val apiInterface = RetrofitSingleton.getClient().create(ApiInterface::class.java)

        val call = apiInterface.posts
        call.enqueue(object : Callback<List<ListofPostModels>> {
            override fun onResponse(
                call: Call<List<ListofPostModels>>,
                response: Response<List<ListofPostModels>>
            ) {

                Log.e("data", Gson().toJson(response.body()))
                data!!.value = response.body()


            }

            override fun onFailure(call: Call<List<ListofPostModels>>, t: Throwable) {
                Log.e("error", t.message)

            }
        })

    }



}
