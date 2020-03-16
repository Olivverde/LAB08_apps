package com.example.gitrepository.mainfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gitrepository.networklayer.GitHubApi
import com.example.gitrepository.networklayer.GitProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * @author olivverde
 * Execute covered operations
 */
class MainViewModel: ViewModel() {

    // User's name
    private var _gitHubUsername = MutableLiveData<String>()
    //Keeps data up-to-date
    val gitHubUsername: LiveData<String>
        get() = _gitHubUsername

    // Profile's picture
    private var profilePic = MutableLiveData<GitProperty>()
    val property: LiveData<GitProperty>
        get() = profilePic

    // Variables
    private val _flag = MutableLiveData<Boolean>()
    val flag: Boolean?
        get() = _flag.value

    // Co-routines
    private var viewModelJob = Job()
    private val coRoutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    /**
     *kills job
     * */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}