package ru.mitapp.umai.api.repository

import okhttp3.ResponseBody
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.AppUmai.Companion.sharedPreferences
import ru.mitapp.umai.api.ApiInterface
import ru.mitapp.umai.base.BaseModel
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


class MainRepository(var api: ApiInterface) : BaseRepository() {


    suspend fun getTerminals(): BaseModel<ArrayList<Terminal>> {
        val response = safeApiCall { api.getTerminalsAsync().await() }

        return response as BaseModel<ArrayList<Terminal>>
    }

    suspend fun getNews(): BaseModel<ArrayList<News>> {
        val response = safeApiCall { api.getNewsAsync().await() }

        return response as BaseModel<ArrayList<News>>
    }

    suspend fun createUser(user: CreateUser): BaseModel<UserToken> {
        val response = safeApiCall { api.createUserAsync(user).await() }

        return response as BaseModel<UserToken>
    }

    suspend fun signIn(singIn: SingIn): BaseModel<UserToken> {
        val response = safeApiCall { api.signInUserAsync(singIn).await() }

        return response as BaseModel<UserToken>
    }

    suspend fun activationUser(
        reference: String,
        smsCode: SmsCode,
        token: String
    ): BaseModel<ResponseBody> {
        val response = safeApiCall { api.activationAsync(reference, smsCode, token).await() }

        return response as BaseModel<ResponseBody>
    }

    suspend fun restorePassword(phone: Phone): BaseModel<String> {
        val response = safeApiCall { api.restorePasswordAsync(phone).await() }

        return response as BaseModel<String>
    }

    suspend fun checkCode(pinCode: PinCode): BaseModel<ResponseBody> {
        val response = safeApiCall { api.checkSmsAsync(pinCode).await() }

        return response as BaseModel<ResponseBody>
    }

    suspend fun newPassword(newPassword: NewPassword): BaseModel<ResponseBody> {
        val response = safeApiCall { api.newPasswordAsync(newPassword).await() }

        return response as BaseModel<ResponseBody>
    }

    suspend fun getServices(): BaseModel<ArrayList<Service>>{
        val response = safeApiCall { api.getServices(sharedPreferences.token!!).await() }
        return response as BaseModel<ArrayList<Service>>
    }

    suspend fun getServicesDetail(type: String): BaseModel<ServiceDetail>{
        val response = safeApiCall { api.getServicesId(type, sharedPreferences.token!!).await() }
        return response as BaseModel<ServiceDetail>
    }

    suspend fun getSecondLevelCategory(id: String): BaseModel<java.util.ArrayList<SubCategoryService>>{
        val response = safeApiCall { api.getServicesSecondLevel(sharedPreferences.token!!, id).await() }
        return response as BaseModel<java.util.ArrayList<SubCategoryService>>
    }

}