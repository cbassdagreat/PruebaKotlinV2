package cbassdagreat.github.pruebakotlinv2.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cbassdagreat.github.pruebakotlinv2.dao.CryptoDao
import cbassdagreat.github.pruebakotlinv2.model.CryptoMonedasItem

@Database(entities = [CryptoMonedasItem::class], version = 1)
abstract class ProyectoDatabase : RoomDatabase() {

    abstract fun cryptoDao() : CryptoDao

    companion object{
        @Volatile
        private var instancia:ProyectoDatabase? = null

        fun getInstancia(context: Context) : ProyectoDatabase
        {
            if(instancia == null)
            {
                synchronized(this)
                {
                    instancia = Room.databaseBuilder(context,
                        ProyectoDatabase::class.java,
                        "proyecto_db")
                        .build()
                }
            }
            return instancia!!
        }
    }
}