package com.example.linah_alkhurayyif_postrequest

import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @GET("/test/")
    fun getListUser(): Call<List<UserDetails.User>>


    @POST("/test/")
    fun addUser(@Body userData: UserDetails.User): Call<UserDetails.User>

    @PUT("/test/{id}")
    fun updateUser(@Path("id") id: Int?, @Body userData: UserDetails.User): Call<UserDetails.User>

    @DELETE("/test/{id}")
    fun deleteUser(@Path("id") id: Int?): Call<Void>
}