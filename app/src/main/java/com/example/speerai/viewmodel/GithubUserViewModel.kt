package com.example.speerai.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speerai.dataclass.GithubDataClass
import com.example.speerai.repository.GithubUserProfileRepository
import kotlinx.coroutines.launch

class GithubUserViewModel:ViewModel(){
    val repository=GithubUserProfileRepository()
    var githubUser= MutableLiveData<GithubDataClass>()
    var githubUserFollower=MutableLiveData<ArrayList<GithubDataClass>>()
    var githubUserFollowing=MutableLiveData<ArrayList<GithubDataClass>>()
    fun getProducts(onFailure:(e:Exception)->Unit){
        viewModelScope.launch {
            try{
                githubUser.value=repository.getGithubUser()
                githubUserFollower.value=repository.getGithubUserFollowers()
                githubUserFollowing.value=repository.getGithubUserFollowing()
            }
            catch (e:Exception){
                onFailure.invoke(e)
            }
        }
    }
}