package ru.mitapp.umai.api

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mitapp.umai.BuildConfig
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit

class ApiFactory(var context: Context) {

    private val BASE_URL : String = "https://umai.kg/"
    private lateinit var retrofit: Retrofit



    private fun getRetrofitClient(): Retrofit? {
            val cookieManager = CookieManager()
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)
            val logging = HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
            val oktHttpClient = OkHttpClient.Builder()
                .connectTimeout(
                    30,
                    TimeUnit.MINUTES
                )
                .writeTimeout(30, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.MINUTES)
                .addInterceptor(ConnectivityInterceptor(context))
                .cookieJar(JavaNetCookieJar(cookieManager))
        oktHttpClient.addInterceptor(logging)

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(oktHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

        return retrofit
    }

    private fun getLoginRetrofitClient(): Retrofit? {
        val cookieManager = CookieManager()
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)
        val logging = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.BODY
        }
        val oktHttpClient = OkHttpClient.Builder()
            .connectTimeout(
                5,
                TimeUnit.MINUTES
            )
            .writeTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
           /* .addInterceptor{
                if (!NetworkUtil.isOnline(context)) {
                    throw NoConnectivityException()
                }

                val builder = it.request().newBuilder()
                return@addInterceptor it.proceed(builder.build())
            }*/
            .cookieJar(JavaNetCookieJar(cookieManager))
             oktHttpClient.addInterceptor(logging)

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(oktHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return retrofit
    }

    val apiInterface : ApiInterface = getRetrofitClient()!!.create(ApiInterface::class.java)
    val loginApiInterface : ApiInterface = getLoginRetrofitClient()!!.create(ApiInterface::class.java)

}

