package kr.hs.ide.nextto.network

import kr.hs.ide.nextto.network.api.NextToService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitImpl {
    private const val BASEURL = "http://:8080"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : NextToService = retrofit.create(NextToService::class.java)
}