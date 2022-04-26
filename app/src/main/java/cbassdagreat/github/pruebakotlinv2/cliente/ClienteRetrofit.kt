package cbassdagreat.github.pruebakotlinv2.cliente

import cbassdagreat.github.pruebakotlinv2.service.CryptoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClienteRetrofit {

    companion object{
        const val BASE_URL = "https://api.coincap.io/v2/"
        private var cliente: Retrofit? = null

        fun getInstancia(url:String) : CryptoService
        {
            if(cliente == null)
            {
                cliente = Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return cliente!!.create(CryptoService::class.java)
        }
    }
}