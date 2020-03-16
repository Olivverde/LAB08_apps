package com.example.gitrepository.networklayer

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * @author olivverde
 * In collaboration with @Brandon
 */
//Default Api's URL
private const val BASE_URL = "https://api.github.com/users/Olivverde"

// Beverage from Guatemala, nah. Start the moshi builder
private val mosh = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
//Provide feedback
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(mosh))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface GitHubApiService{
    @GET("realestate")
    fun getProperties():
            Deferred<List<GitProperty>>
}
//Api stuff
object GitHubApi{
    val retrofitService: GitHubApiService by lazy {
        retrofit.create(GitHubApiService::class.java)
    }
}