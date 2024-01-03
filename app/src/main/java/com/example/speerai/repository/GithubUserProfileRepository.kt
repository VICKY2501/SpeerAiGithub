package com.example.speerai.repository

import com.example.speerai.dataclass.GithubDataClass
import com.example.speerai.retrofit.Retrofit

class GithubUserProfileRepository {
    suspend fun getGithubUser():GithubDataClass{
        return Retrofit.apiInstance.githubUser("lks")
    }
    suspend fun getGithubUserFollowers():ArrayList<GithubDataClass>{
        return Retrofit.apiInstance.githubUserFollowers("lks")
    }
    suspend fun getGithubUserFollowing():ArrayList<GithubDataClass>{
        return Retrofit.apiInstance.githubUserFollowing("lks")
    }
}