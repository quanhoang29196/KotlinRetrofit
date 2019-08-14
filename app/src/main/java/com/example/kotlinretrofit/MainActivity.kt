package com.example.kotlinretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private var myAdapter: MyAdapter? = null
    private val BASE_URL = "https://api.something"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()


    }

    fun loadData() {
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var Api = retrofit.create(API::class.java)

        var call = Api.getUsers()

        call.enqueue(object : Callback<UsersList> {
            override fun onFailure(call: Call<UsersList>?, t: Throwable?) {
                Log.v("Error", t.toString())
            }

            override fun onResponse(call: Call<UsersList>, response: Response<UsersList>) {
                var users = response.body()
                var user = users?.users


            }

        })


    }


}
