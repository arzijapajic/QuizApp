
import com.google.gson.annotations.SerializedName

data class Odgovor(
    @SerializedName("id")
    val id: Int,
    @SerializedName("odgovoreno")
    val odgovoreno: Int
)