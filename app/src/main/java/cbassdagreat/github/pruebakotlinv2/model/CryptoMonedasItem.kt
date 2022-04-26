package cbassdagreat.github.pruebakotlinv2.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "crypto")
data class CryptoMonedasItem(
    @SerializedName("id")
    @PrimaryKey
    val id: String,
    @SerializedName("marketCapUsd")
    val marketCapUsd: String?,
    @SerializedName("maxSupply")
    val maxSupply: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("priceUsd")
    val priceUsd: String?,
    @SerializedName("symbol")
    val symbol: String?,

)