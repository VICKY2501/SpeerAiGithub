package com.example.speerai.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speerai.dataclass.GithubDataClass
import com.example.speerai.repository.GithubUserProfileRepository
import kotlinx.coroutines.launch

class GithubUserListViewModel:ViewModel() {
    val repository= GithubUserProfileRepository()
    var githubUserFollower= MutableLiveData<ArrayList<GithubDataClass>>()
    var githubUserFollowing= MutableLiveData<ArrayList<GithubDataClass>>()
    fun getUserList(userName:String,onFailure:(e:Exception)->Unit){
        viewModelScope.launch {
            try{
                githubUserFollower.value=repository.getGithubUserFollowers(userName)
                githubUserFollowing.value=repository.getGithubUserFollowing(userName)
            }
            catch (e:Exception){
                onFailure.invoke(e)
            }
        }
    }
}