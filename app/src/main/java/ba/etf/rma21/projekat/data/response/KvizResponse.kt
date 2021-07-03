package ba.etf.rma21.projekat.data.response

import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.KvizStatus
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

data class KvizResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("naziv")
    val naziv: String,
    @SerializedName("datumPocetka")
    val datumPocetka: String,
    @SerializedName("datumKraj")
    val datumKraj: String,
    @SerializedName("trajanje")
    val trajanje: Int
)

fun KvizResponse.mapToDomain(): Kviz {
    val formater = SimpleDateFormat("yyyy-mm-dd")
    return Kviz(
        naziv,
        "",
        Date(121, Calendar.MAY, 21),
        Date(121, Calendar.MAY, 21),
        null,
         trajanje,
        "",
        null,
        KvizStatus.ACTIVE,
        id
    )

}