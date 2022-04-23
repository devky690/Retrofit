package edu.towson.cosc435.abrahams.kotlin_requests.repository

import edu.towson.cosc435.abrahams.kotlin_requests.api.RetrofitInstance
import edu.towson.cosc435.abrahams.kotlin_requests.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}