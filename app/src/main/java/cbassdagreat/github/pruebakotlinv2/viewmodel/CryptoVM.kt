package cbassdagreat.github.pruebakotlinv2.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedas
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedasItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoVM (application: Application) : AndroidViewModel(application){

        val monedas = MutableLiveData<CryptoMonedas>()
        val moneda = MutableLiveData<CryptoMonedasItem>()

      /**  fun getData()
        {
            val service = ClienteRetrofit.getInstancia(ClienteRetrofit.BASE_URL)
            service.getCursos().enqueue(object  : Callback<CryptoMonedas> {
                override fun onResponse(call: Call<CryptoMonedas>, response: Response<CryptoMonedas>) {
                    response.body().let {
                        monedas.postValue(it)
                    }
                }
                override fun onFailure(call: Call<CryptoMonedas>, t: Throwable) {
                    Log.e("CALL",t.message.toString())
                }

            })
        }
**/
        fun updateCurso(moneda:CryptoMonedasItem)
        {
            this.moneda.value = moneda
        }
    }
