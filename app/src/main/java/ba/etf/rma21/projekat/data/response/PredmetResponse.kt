package ba.etf.rma21.projekat.data.response


import com.google.gson.annotations.SerializedName

data class PredmetResponse(
    @SerializedName("godina")
    val godina: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("naziv")
    val naziv: String
)