package ru.mitapp.umai.api

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import ru.mitapp.umai.models.Terminal
import ru.mitapp.umai.models.news.News
import ru.mitapp.umai.models.register.CreateUser
import ru.mitapp.umai.models.register.SmsCode
import ru.mitapp.umai.models.register.UserToken


interface ApiInterface {

    @GET("api/terminals")
    fun getTerminals() : Deferred<Response<ArrayList<Terminal>>>

    @GET("api/news")
    fun getNews() : Deferred<Response<ArrayList<News>>>

    @POST("api/users")
    fun createUser(@Body user: CreateUser): Deferred<Response<UserToken>>

    @PUT("api/users/:reference/activations")
    fun activation(@Body smsCode: SmsCode): Deferred<Response<SmsCode>>

}