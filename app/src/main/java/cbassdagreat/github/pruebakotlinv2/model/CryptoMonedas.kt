package cbassdagreat.github.pruebakotlinv2.model


import com.google.gson.annotations.SerializedName

data class CryptoMonedas(
    @SerializedName("data")
    val data: List<CryptoMonedasItem>
)