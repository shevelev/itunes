package space.forasoft.models

import com.google.gson.annotations.SerializedName

class AlbumInfoResponse (
    @SerializedName("results")
    val albumInfo2: List<AlbumInfo>
)