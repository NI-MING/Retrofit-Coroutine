package com.wlk.retrofit_coroutine

import retrofit2.http.GET

interface ProjectApi {

    @GET("project/tree/json")
    suspend fun loadProjectTree(): ProjectTree

}