package ba.etf.rma21.projekat.data.response


import com.google.gson.annotations.SerializedName

data class StudentResponse(
    @SerializedName("acHash")
    val acHash: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("student")
    val student: String
)