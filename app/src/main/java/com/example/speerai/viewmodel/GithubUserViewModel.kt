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
    fun getProducts(userName:String,onFailure:(e:Exception)->Unit){
        viewModelScope.launch {
            try{
                githubUser.value=repository.getGithubUser(userName)
            }
            catch (e:Exception){
                onFailure.invoke(e)
            }
        }
    }
}