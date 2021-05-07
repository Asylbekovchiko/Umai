package ru.mitapp.umai.api.repository

import ru.mitapp.umai.api.ApiInterface
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.models.Terminal
import ru.mitapp.umai.models.auth.*
import ru.mitapp.umai.models.news.News


class MainRepository(var api: ApiInterface) : BaseRepository() {


    suspend fun getTerminals() : BaseModel<ArrayList<Terminal>>{
        val response = safeApiCall {api.getTerminalsAsync().await()}

        return response as BaseModel<ArrayList<Terminal>>
    }
    suspend fun getNews() : BaseModel<ArrayList<News>>{
        val response = safeApiCall {api.getNewsAsync().await()}

        return response as BaseModel<ArrayList<News>>
    }

    suspend fun createUser(user: CreateUser) : BaseModel<UserToken>{
        val response = safeApiCall {api.createUserAsync(user).await()}

        return response as BaseModel<UserToken>
    }

    suspend fun signIn(singIn: SingIn) : BaseModel<UserToken>{
        val response = safeApiCall {api.signInUserAsync(singIn).await()}

        return response as BaseModel<UserToken>
    }

    suspend fun activationUser( reference: String, smsCode: SmsCode, token: String) : BaseModel<SmsCode>{
        val response = safeApiCall {api.activationAsync(reference, smsCode, token).await()}

        return response as BaseModel<SmsCode>
    }

    suspend fun restorePassword(phone: Phone) : BaseModel<String>{
        val response = safeApiCall {api.restorePasswordAsync(phone).await()}

        return response as BaseModel<String>
    }

}