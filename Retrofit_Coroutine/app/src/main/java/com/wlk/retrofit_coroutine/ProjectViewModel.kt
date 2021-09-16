package com.wlk.retrofit_coroutine

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ProjectViewModel: BaseViewModel() {

    val mRepo = ProjectRepo()
    val mProjectTreeLivaData = MutableLiveData<List<Data>>()

    fun getProjectTree(){
        launch(
            {
                val data = mRepo.loadProjectTree()
                mProjectTreeLivaData.postValue(data)
            },
            {
                errorLivaData.postValue(it)
            },
            {
                loadingLivaData.postValue(false)
            }
        )
    }

}