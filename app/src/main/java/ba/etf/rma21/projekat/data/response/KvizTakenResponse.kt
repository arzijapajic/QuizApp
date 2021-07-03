package ba.etf.rma21.projekat.data.response

import com.google.gson.annotations.SerializedName
import java.util.*

data class KvizTakenResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("student")
    val student: String,
    @SerializedName("osvojeniBodovi")
    val osvojeniBodovi: Number,
    @SerializedName("datumRada")
    val datumRada: Date
)