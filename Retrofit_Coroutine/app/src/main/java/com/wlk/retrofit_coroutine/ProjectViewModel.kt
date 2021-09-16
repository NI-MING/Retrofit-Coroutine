package com.wlk.retrofit_coroutine

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ProjectViewModel: ViewModel() {

    val mRepo = ProjectRepo()
    val mProjectTreeLivaData = MutableLiveData<List<Data>>()
    val errorLivaData = MutableLiveData<Throwable>()

    fun getProjectTree(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val data = mRepo.loadProjectTree()
                mProjectTreeLivaData.postValue(data)
            }catch (e:Exception){
                errorLivaData.postValue(e)
            }
        }
    }

}