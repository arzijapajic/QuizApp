package ba.etf.rma21.projekat.data.response


import com.google.gson.annotations.SerializedName

data class DodajUGrupuResponse(
    @SerializedName("message")
    val message: String
)