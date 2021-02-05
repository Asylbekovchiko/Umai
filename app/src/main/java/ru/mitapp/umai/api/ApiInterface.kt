package ru.mitapp.umai.api

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import ru.mitapp.umai.models.Terminal


interface ApiInterface {

    @GET("api/terminals")
    fun getTerminals() : Deferred<Response<ArrayList<Terminal>>>


}