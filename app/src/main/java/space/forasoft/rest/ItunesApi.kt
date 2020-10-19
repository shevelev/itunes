package space.forasoft.rest

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItunesApi {
    companion object {
        val baseURL: String = "https://itunes.apple.com/"

        fun retrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }
}