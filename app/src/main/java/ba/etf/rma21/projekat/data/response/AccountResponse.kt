
import com.google.gson.annotations.SerializedName

data class AccountResponse(
    @SerializedName("acHash")
    val acHash: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("student")
    val student: String
)