package ru.mitapp.umai.api.repository

import ru.mitapp.umai.api.ApiInterface
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.models.Terminal


class MainRepository(var api: ApiInterface) : BaseRepository() {


    suspend fun getTerminals() : BaseModel<ArrayList<Terminal>>{
        val response = safeApiCall {api.getTerminals().await()}

        return response as BaseModel<ArrayList<Terminal>>
    }


}