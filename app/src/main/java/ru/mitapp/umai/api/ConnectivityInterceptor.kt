package ru.mitapp.umai.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ConnectivityInterceptor(var context : Context) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkUtil.isOnline(context)) {
            throw NoConnectivityException()
        }


        val newRequest: Request

        val request = chain.request()
        newRequest = request.newBuilder()
            .build()
        return chain.proceed(newRequest)    }
}