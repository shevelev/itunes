package space.forasoft.models

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("artworkUrl100")
    val imgAlbum: String,
    @SerializedName("collectionName")
    val descrAlbum: String,
    @SerializedName("artistName")
    val artist: String,
    @SerializedName("collectionId")
    val albumId: String
)