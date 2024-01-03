package com.example.speerai.retrofit

import com.example.speerai.dataclass.GithubDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{id}")
    suspend fun githubUser(@Path("id") login: String): GithubDataClass
    @GET("users/{id}/followers")
    suspend fun githubUserFollowers(@Path("id") login: String): ArrayList<GithubDataClass>
    @GET("users/{id}/following")
    suspend fun githubUserFollowing(@Path("id") login: String): ArrayList<GithubDataClass>
}
