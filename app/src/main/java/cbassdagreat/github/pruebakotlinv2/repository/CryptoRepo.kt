package cbassdagreat.github.pruebakotlinv2.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedas
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedasItem
import cbassdagreat.github.pruebakotlinv2.room.ProyectoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptoRepo(var context: Context) {

    private val db = ProyectoDatabase.getInstancia(context)

    fun agregar(cryptoMonedas:List<CryptoMonedasItem>)
    {
        CoroutineScope(Dispatchers.IO).launch {
            db.cryptoDao().agregar(cryptoMonedas)
        }
    }

    fun listar() : LiveData<List<CryptoMonedasItem>>
    {
        return db.cryptoDao().listar()
    }

    fun buscar(id:String) : CryptoMonedasItem
    {
        return db.cryptoDao().buscar(id)
    }

    fun getCount() : Int{
        return  db.cryptoDao().contar()
    }
}