package space.forasoft.models

import com.google.gson.annotations.SerializedName

data class AlbumResponse(
    @SerializedName("results")
    val albums: List<Album>
)