package ru.mitapp.umai.api

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
import ru.mitapp.umai.models.Terminal
import ru.mitapp.umai.models.auth.*
import ru.mitapp.umai.models.news.News


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

    @PUT("api/my/password/validate-token")
    fun checkSmsAsync(@Body pin: PinCode): Deferred<Response<ResponseBody>>

    @PUT("api/my/password/restore")
    fun newPasswordAsync(@Body newPassword: NewPassword): Deferred<Response<ResponseBody>>
}