package ru.mitapp.umai.api

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*
import ru.mitapp.umai.models.Terminal
import ru.mitapp.umai.models.news.News
import ru.mitapp.umai.models.auth.CreateUser
import ru.mitapp.umai.models.auth.SmsCode
import ru.mitapp.umai.models.auth.UserToken
import ru.mitapp.umai.models.auth.SingIn
import ru.mitapp.umai.models.service.Service
import ru.mitapp.umai.models.service.SubCategoryService


interface ApiInterface {

    @GET("api/terminals")
    fun getTerminals() : Deferred<Response<ArrayList<Terminal>>>

    @GET("api/news")
    fun getNews() : Deferred<Response<ArrayList<News>>>

    @POST("api/users")
    fun createUser(@Body user: CreateUser): Deferred<Response<UserToken>>

    @POST("api/auth/local")
    fun signInUser(@Body singIn: SingIn): Deferred<Response<UserToken>>

    @PUT("api/users/{reference}/activations")
    fun activation(@Path("reference") reference: String, @Body smsCode: SmsCode, @Query("access_token") token: String): Deferred<Response<SmsCode>>

    @GET("api/v2/service-provider-categories")
    fun getServices(@Query("access_token") token: String): Deferred<Response<ArrayList<Service>>>

    @GET("api/v2/service-providers")
    fun getServicesSecondLevel(@Query("access_token") token: String, @Query("category") category: String): Deferred<Response<java.util.ArrayList<SubCategoryService>>>

}