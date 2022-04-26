package cbassdagreat.github.pruebakotlinv2.repository

import cbassdagreat.github.pruebakotlinv2.cliente.ClienteRetrofit
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedas
import retrofit2.Call

class ClienteRepo {

    private val cliente = ClienteRetrofit.getInstancia(ClienteRetrofit.BASE_URL)
    fun getListaCrypto(): Call<CryptoMonedas>
    {
        return cliente.getCrypto()
    }
}