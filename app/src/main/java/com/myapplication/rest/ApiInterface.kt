package com.myapplication.rest

import com.myapplication.model.ListofAlbumsModel
import com.myapplication.model.ListofPostModels
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @get:GET("posts")
    val posts: Call<List<ListofPostModels>>

    @get:GET("albums")
    val albumList: Call<List<ListofAlbumsModel>>


}
