package ru.mitapp.umai.api.repository

import ru.mitapp.umai.api.ApiInterface
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.models.Terminal
import ru.mitapp.umai.models.news.News
import ru.mitapp.umai.models.register.CreateUser
import ru.mitapp.umai.models.register.UserToken


class MainRepository(var api: ApiInterface) : BaseRepository() {


    suspend fun getTerminals() : BaseModel<ArrayList<Terminal>>{
        val response = safeApiCall {api.getTerminals().await()}

        return response as BaseModel<ArrayList<Terminal>>
    }
    suspend fun getNews() : BaseModel<ArrayList<News>>{
        val response = safeApiCall {api.getNews().await()}

        return response as BaseModel<ArrayList<News>>
    }

    suspend fun createUser(user: CreateUser) : BaseModel<UserToken>{
        val response = safeApiCall {api.createUser(user).await()}

        return response as BaseModel<UserToken>
    }
}