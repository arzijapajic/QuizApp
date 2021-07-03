package ba.etf.rma21.projekat.data.response

import com.google.gson.annotations.SerializedName

data class PitanjeResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("naziv")
    val naziv: String,
    @SerializedName("tekstPitanja")
    val tekstPitanja: String,
    @SerializedName("opcije")
    val opcije: List<String>,
    @SerializedName("tacan")
    val tacan: Int
)