package ru.mitapp.umai.api.repository

import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.AppUmai.Companion.sharedPreferences
import ru.mitapp.umai.api.ApiInterface
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.models.Terminal
import ru.mitapp.umai.models.news.News
import ru.mitapp.umai.models.auth.CreateUser
import ru.mitapp.umai.models.auth.SmsCode
import ru.mitapp.umai.models.auth.UserToken
import ru.mitapp.umai.models.auth.SingIn
import ru.mitapp.umai.models.service.Service


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

    suspend fun signIn(singIn: SingIn) : BaseModel<UserToken>{
        val response = safeApiCall {api.signInUser(singIn).await()}

        return response as BaseModel<UserToken>
    }

    suspend fun activationUser( reference: String, smsCode: SmsCode, token: String) : BaseModel<SmsCode>{
        val response = safeApiCall {api.activation(reference, smsCode, token).await()}

        return response as BaseModel<SmsCode>
    }

    suspend fun getServices(): BaseModel<ArrayList<Service>>{
        val response = safeApiCall { api.getServices(sharedPreferences.token!!).await() }
        return response as BaseModel<ArrayList<Service>>
    }

}