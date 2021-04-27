package ru.mitapp.umai.api.repository

import ru.mitapp.umai.api.ApiInterface
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.models.Terminal
import ru.mitapp.umai.models.news.News


class MainRepository(var api: ApiInterface) : BaseRepository() {


    suspend fun getTerminals() : BaseModel<ArrayList<Terminal>>{
        val response = safeApiCall {api.getTerminals().await()}

        return response as BaseModel<ArrayList<Terminal>>
    }
    suspend fun getNews() : BaseModel<ArrayList<News>>{
        val response = safeApiCall {api.getNews().await()}

        return response as BaseModel<ArrayList<News>>
    }


}