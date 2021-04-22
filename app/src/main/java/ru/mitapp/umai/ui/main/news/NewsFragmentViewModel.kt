package ru.mitapp.umai.ui.main.news

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.base.BaseViewModel
import ru.mitapp.umai.models.news.News
import java.lang.Exception

class NewsFragmentViewModel : BaseViewModel() {
    var isLoad = ObservableField(false)

    val newsData : MutableLiveData<BaseModel<ArrayList<News>>> by lazy {
        MutableLiveData<BaseModel<ArrayList<News>>>()
    }

    fun getNews(){
        scope.launch {
            try {
                isLoad.set(true)
                val newsList = AppUmai.repository.getNews()
                setNewsData(newsList)
                isLoad.set(false)
            } catch (e : Exception){
                e.stackTrace
                isLoad.set(false)
            }
        }

    }

    private suspend fun setNewsData(news: BaseModel<ArrayList<News>>) : LiveData<BaseModel<ArrayList<News>>> {
        withContext(Dispatchers.Main){
            newsData.value = news
        }

        return newsData
    }
}