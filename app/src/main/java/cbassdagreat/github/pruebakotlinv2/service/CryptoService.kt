package cbassdagreat.github.pruebakotlinv2.service

import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedas
import retrofit2.Call
import retrofit2.http.GET

interface CryptoService {

    @GET("list?access_key=dfb0a4bdc4bfb1a0da1ab21f5d3e4c4e")
    fun getCrypto() : Call<CryptoMonedas>
}