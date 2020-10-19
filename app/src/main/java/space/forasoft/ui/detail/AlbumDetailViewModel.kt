package space.forasoft.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import space.forasoft.models.AlbumInfo
import space.forasoft.models.Songs
import space.forasoft.rest.ItunesApi.Companion.retrofit
import space.forasoft.rest.ItunesApiInterface

class AlbumDetailViewModel : ViewModel() {
    val songListData: MutableLiveData<List<Songs>> = MutableLiveData()
    val albumInfo: MutableLiveData<List<AlbumInfo>> = MutableLiveData()

    fun load(s: String) {

        val api = retrofit().create(ItunesApiInterface::class.java)

        viewModelScope.launch {
            val result = api.getTracksFromAlbumId(s)
            result.body()?.songs?.filter { it.kind == "song" }.let {
                songListData.postValue(it)
            }

            val resultInfo = api.getAlbumInfo(s)

            resultInfo.body()?.albumInfo2?.let {
                albumInfo.postValue(it)
            }
        }
    }
}