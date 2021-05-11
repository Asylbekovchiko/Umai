package ru.mitapp.umai.api

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
import ru.mitapp.umai.models.Terminal
import ru.mitapp.umai.models.auth.*
import ru.mitapp.umai.models.news.News
import ru.mitapp.umai.models.auth.CreateUser
import ru.mitapp.umai.models.auth.SmsCode
import ru.mitapp.umai.models.auth.UserToken
import ru.mitapp.umai.models.auth.SingIn
import ru.mitapp.umai.models.service.Service
import ru.mitapp.umai.models.service.ServiceDetail
import ru.mitapp.umai.models.service.SubCategoryService


interface ApiInterface {

    @GET("api/terminals")
    fun getTerminalsAsync() : Deferred<Response<ArrayList<Terminal>>>

    @GET("api/news")
    fun getNewsAsync() : Deferred<Response<ArrayList<News>>>

    @POST("api/users")
    fun createUserAsync(@Body user: CreateUser): Deferred<Response<UserToken>>

    @POST("api/auth/local")
    fun signInUserAsync(@Body singIn: SingIn): Deferred<Response<UserToken>>

    @PUT("api/users/{reference}/activations")
    fun activationAsync(@Path("reference") reference: String,
                        @Body smsCode: SmsCode,
                        @Query("access_token")
                   token: String): Deferred<Response<ResponseBody>>

    @POST("api/my/password")
    fun restorePasswordAsync(@Body phone: Phone): Deferred<Response<String>>

    @GET("api/v2/service-provider-categories")
    fun getServices(@Query("access_token") token: String): Deferred<Response<ArrayList<Service>>>

    @GET("api/v2/service-providers/{type}")
    fun getServicesId(@Path("type")type: String,@Query("access_token") token: String): Deferred<Response<ServiceDetail>>

    @GET("api/v2/service-providers")
    fun getServicesSecondLevel(@Query("access_token") token: String, @Query("category") category: String): Deferred<Response<java.util.ArrayList<SubCategoryService>>>

    @PUT("api/my/password/validate-token")
    fun checkSmsAsync(@Body pin: PinCode): Deferred<Response<ResponseBody>>

    @PUT("api/my/password/restore")
    fun newPasswordAsync(@Body newPassword: NewPassword): Deferred<Response<ResponseBody>>
}