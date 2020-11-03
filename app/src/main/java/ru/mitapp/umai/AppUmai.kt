package ru.mitapp.umai

import android.app.Application
import android.content.Context
import ru.mitapp.umai.api.ApiFactory
import ru.mitapp.umai.api.repository.MainRepository
import ru.mitapp.umai.localstorage.SharedPreference

class AppUmai : Application() {

    companion object{
        lateinit var context: Context
        lateinit var repository : MainRepository
        lateinit var sharedPreferences : SharedPreference
    }


    override fun onCreate() {
        super.onCreate()

        context = applicationContext
//        repository = MainRepository(ApiFactory(context).apiInterface)
        sharedPreferences = SharedPreference(applicationContext)
    }
}