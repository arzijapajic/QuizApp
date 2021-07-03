package ba.etf.rma21.projekat.data.api

import ba.etf.rma21.projekat.data.response.PitanjeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PitanjaApi {

    @GET("/kviz/{id}/pitanja")
    suspend fun dajPitanjaId(@Path("id") idKviza: Int): List<PitanjeResponse>
}