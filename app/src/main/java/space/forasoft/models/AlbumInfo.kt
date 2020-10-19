package space.forasoft.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class AlbumInfo(
    @SerializedName("artistName")
    val artistName: String,
    @SerializedName("collectionName")
    val collectionName: String,
    @SerializedName("artworkUrl100")
    val artworkUrl100: String,
    @SerializedName("releaseDate")
    val releaseDate: Date,
    @SerializedName("primaryGenreName")
    val primaryGenreName: String
)