package edu.towson.cosc435.abrahams.kotlin_requests.api

import edu.towson.cosc435.abrahams.kotlin_requests.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    //lazy initialization:
    //delay the creation of object until first time it is needed
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApi by lazy{
        retrofit.create(SimpleApi::class.java)
    }
}