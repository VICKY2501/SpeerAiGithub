package com.example.speerai.retrofit

import com.example.speerai.dataclass.GithubDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{id}")
    fun githubUser(@Path("id") login: String): GithubDataClass
    @GET("users/{id}/followers")
    fun githubUserFollowers(@Path("id") login: String): ArrayList<GithubDataClass>
    @GET("users/{id}/following")
    fun githubUserFollowing(@Path("id") login: String): ArrayList<GithubDataClass>
}
