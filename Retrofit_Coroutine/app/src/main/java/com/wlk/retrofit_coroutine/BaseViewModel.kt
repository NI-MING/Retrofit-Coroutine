package com.wlk.retrofit_coroutine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

open class BaseViewModel: ViewModel() {

    // 网络错误
    val errorLivaData = MutableLiveData<Throwable>()
    // 正在加载
    val loadingLivaData = MutableLiveData<Boolean>()

    fun launch(
        block: suspend() -> Unit,
        error: suspend(Throwable) -> Unit,
        complete: suspend() -> Unit
    ){
        loadingLivaData.postValue(true)
        viewModelScope.launch(Dispatchers.IO){
            try {
                block()
            }catch (e: Exception){
                error(e)
            }finally {
                complete()
            }
        }

    }

}