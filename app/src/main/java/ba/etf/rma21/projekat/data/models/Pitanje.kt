package ba.etf.rma21.projekat.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pitanje(
        val naziv: String,
        val tekstPitanja: String,
        val opcije: List<String>,
        val tacan: Int,
        val nazivKviza: String? = null,
        val nazivPredmeta: String? = null,
        val id: Int? = null,
        var odgovor: Int? = null
): Parcelable {
}
