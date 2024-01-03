package com.example.speerai.repository

import com.example.speerai.dataclass.GithubDataClass
import com.example.speerai.retrofit.Retrofit

class GithubUserProfileRepository  {
    suspend fun getGithubUser(userName:String):GithubDataClass{
        return Retrofit.apiInstance.githubUser(userName)
    }
    suspend fun getGithubUserFollowers(userName:String):ArrayList<GithubDataClass>{
        return Retrofit.apiInstance.githubUserFollowers(userName)
    }
    suspend fun getGithubUserFollowing(userName:String):ArrayList<GithubDataClass>{
        return Retrofit.apiInstance.githubUserFollowing(userName)
    }
}