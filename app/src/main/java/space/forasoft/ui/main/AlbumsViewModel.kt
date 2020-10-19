package space.forasoft.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import space.forasoft.models.Album
import space.forasoft.rest.ItunesApi.Companion.retrofit
import space.forasoft.rest.ItunesApiInterface

class AlbumsViewModel : ViewModel() {

    val albumListData : MutableLiveData<List<Album>> = MutableLiveData()

    fun load(s: String) {

        val api = retrofit().create(ItunesApiInterface::class.java)

        viewModelScope.launch {
            val result = api.getAlbums(s)

            result.body()?.albums?.let {
                albumListData.postValue(it.sortedBy { it.descrAlbum })
            }
        }
    }
}