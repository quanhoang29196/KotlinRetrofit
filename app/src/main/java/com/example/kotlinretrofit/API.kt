package com.example.kotlinretrofit

import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("users?q=rokano")
    fun getUsers(): Call<UsersList>
}
