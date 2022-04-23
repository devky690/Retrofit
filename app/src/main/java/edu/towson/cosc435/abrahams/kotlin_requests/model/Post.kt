package edu.towson.cosc435.abrahams.kotlin_requests.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userId")
    val user_id: Int,
    val id: Int,
    val title: String,
    val body: String
)
