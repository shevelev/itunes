package space.forasoft.models

import com.google.gson.annotations.SerializedName

data class SongsResponse(
    @SerializedName("results")
    val songs: List<Songs>
)