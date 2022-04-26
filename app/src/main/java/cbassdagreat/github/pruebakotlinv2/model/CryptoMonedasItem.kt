package cbassdagreat.github.pruebakotlinv2.model


import com.google.gson.annotations.SerializedName

data class CryptoMonedasItem(
    @SerializedName("id")
    val id: String?,
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
    @SerializedName("vwap24Hr")
    val vwap24Hr: String?
)