package space.forasoft.rest

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import space.forasoft.models.AlbumInfo
import space.forasoft.models.AlbumInfoResponse
import space.forasoft.models.AlbumResponse
import space.forasoft.models.SongsResponse

interface ItunesApiInterface {
    @GET("/search")
    suspend fun getAlbums(
        @Query("term") search: String,
        @Query("country") country: String = "us",
        @Query("entity") entity: String = "album"
    ): Response<AlbumResponse>

    @GET("/lookup")
    suspend fun getTracksFromAlbumId(
        @Query("id") id: String,
        @Query("entity") entity: String = "song"
    ): Response<SongsResponse>

    @GET("/lookup")
    suspend fun getAlbumInfo(
        @Query("id") id: String
    ): Response<AlbumInfoResponse>
}