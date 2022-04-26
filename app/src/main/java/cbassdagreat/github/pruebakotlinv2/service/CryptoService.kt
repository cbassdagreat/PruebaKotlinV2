package cbassdagreat.github.pruebakotlinv2.service

import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedas
import retrofit2.Call
import retrofit2.http.GET

interface CryptoService {

    @GET("assets")
    fun getCrypto() : Call<CryptoMonedas>
}