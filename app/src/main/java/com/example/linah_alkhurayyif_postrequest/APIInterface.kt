package com.example.linah_alkhurayyif_postrequest

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIInterface {

    @GET("/test/")
    fun doGetListUser(): Call<List<UserDetails.User>>


    @POST("/test/")
    fun doaddUser(@Body userData: UserDetails.User): Call<UserDetails.User>
}