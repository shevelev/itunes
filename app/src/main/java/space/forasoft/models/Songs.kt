package space.forasoft.models

import com.google.gson.annotations.SerializedName

data class Songs (
    @SerializedName("trackName")
    val trackName: String,
    @SerializedName("trackNumber")
    val trackNumber: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("trackTimeMillis")
    val trackTimeMillis: Long
)