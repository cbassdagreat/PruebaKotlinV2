package cbassdagreat.github.pruebakotlinv2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedas
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedasItem

@Dao
interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun agregar(cryptoMonedas: CryptoMonedas)

    @Query("select id, name, marketCapUsd, maxSupply, priceUsd, symbol from crypto")
    fun listar() : LiveData<List<CryptoMonedasItem>>

    @Query("select id,name, marketCapUsd, maxSupply, priceUsd, symbol from crypto where id = :id")
    fun buscar(id:String) :CryptoMonedasItem

    @Query("select count(*) from crypto")
    fun contar():Int


}