package ru.mitapp.umai.api.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import retrofit2.Response
import ru.mitapp.umai.base.BaseModel
import java.io.IOException
import java.lang.reflect.Type

open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Any? {

        val result: Result<T> = safeApiResult(call)
        var data: Any? = null

        when (result) {
            is Result.Success ->
                data = result.data
            is Result.Error -> {
                Log.d("1.DataRepository", "Exception - ${result.exception}")
            }
        }


        return data

    }

    private suspend fun <T : Any> safeApiResult(call: suspend () -> Response<T>): Result<T> {
        val response = call.invoke()
        var baseModel: BaseModel<T> = BaseModel()
        if (response.isSuccessful) {
            baseModel.data = response.body()
            baseModel.responseCode = response.code()
        }else {
            val errorMsg = JSONObject(response.errorBody()!!.string()).toString()
            val type: Type = object : TypeToken<BaseModel<T>>() {}.type
            baseModel = Gson().fromJson(errorMsg, type)
            baseModel.responseCode = response.code()
        }

        return Result.Success(baseModel)
    }
}