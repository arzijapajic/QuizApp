package ba.etf.rma21.projekat.data.models

data class Student(val ime: String,val hash: String, val id: Int) {
    val upisaneGrupe = mutableListOf<Grupa>()
}