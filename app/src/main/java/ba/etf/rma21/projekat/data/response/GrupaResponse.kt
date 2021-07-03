package ba.etf.rma21.projekat.data.response


import com.google.gson.annotations.SerializedName

data class GrupaResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("naziv")
    val naziv: String
)