package ba.etf.rma21.projekat.data.response

import com.google.gson.annotations.SerializedName

data class OdgovorResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("odgovoreno")
    val odgovoreno: Int
)