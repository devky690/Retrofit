package edu.towson.cosc435.abrahams.kotlin_requests.api

import edu.towson.cosc435.abrahams.kotlin_requests.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost(): Response<Post>
}