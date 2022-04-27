package cbassdagreat.github.pruebakotlinv2.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cbassdagreat.github.pruebakotlinv2.cliente.ClienteRetrofit
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedas
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedasItem
import cbassdagreat.github.pruebakotlinv2.repository.ClienteRepo
import cbassdagreat.github.pruebakotlinv2.repository.CryptoRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoVM (application: Application) : AndroidViewModel(application){

        private val clienteRepo = ClienteRepo()
        private val cryptoRepo = CryptoRepo(getApplication())
        val monedas = cryptoRepo.listar()
        val moneda = MutableLiveData<CryptoMonedasItem>()

      fun getData()
        {
           CoroutineScope(Dispatchers.IO).launch {
               if (cryptoRepo.getCount() == 0){
                   clienteRepo.getListaCrypto().enqueue(object : Callback<CryptoMonedas> {
                       override fun onResponse(
                           call: Call<CryptoMonedas>,
                           response: Response<CryptoMonedas>
                       ) {
                               response.body().let {
                                   cryptoRepo.agregar(it!!.data)
                               }
                       }

                       override fun onFailure(call: Call<CryptoMonedas>, t: Throwable) {
                           Log.e("CALL", t.message.toString())

                       }
                   })
           }

        }

        }
    fun updateCrypto(id:String)
    {
        CoroutineScope(Dispatchers.IO).launch {
            moneda.postValue(cryptoRepo.buscar(id))
        }
    }
}
//var lista:List<CryptoMonedasItem> = ArrayList()
