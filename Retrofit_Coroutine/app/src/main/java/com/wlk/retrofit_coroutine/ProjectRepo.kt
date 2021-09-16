package com.wlk.retrofit_coroutine

import java.util.*

class ProjectRepo {

    private lateinit var mService: ProjectApi

    init {
        mService = RetrofitManager.initRetrofit().getService(ProjectApi::class.java)
    }

    suspend fun loadProjectTree(): List<Data>{
        return mService.loadProjectTree().data
    }

}