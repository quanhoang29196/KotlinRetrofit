package com.example.kotlinretrofit

import com.google.gson.annotations.SerializedName

class UsersList {
    @SerializedName("users")
    var users: List<Users>? = null
}