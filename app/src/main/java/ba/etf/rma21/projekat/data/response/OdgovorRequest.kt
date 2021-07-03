package ba.etf.rma21.projekat.data.response


import com.google.gson.annotations.SerializedName

data class OdgovorRequest(
    @SerializedName("bodovi")
    val bodovi: Int,
    @SerializedName("odgovor")
    val odgovor: Int,
    @SerializedName("pitanje")
    val pitanje: Int
)