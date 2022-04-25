package cbassdagreat.github.pruebakotlinv2.model


import com.google.gson.annotations.SerializedName

data class CryptoMonedasItem(
    @SerializedName("icon_url")
    val iconUrl: String?,
    @SerializedName("max_supply")
    val maxSupply: Long?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("name_full")
    val nameFull: String?,
    @SerializedName("symbol")
    val symbol: String?
)