package ba.etf.rma21.projekat.data.api

import ba.etf.rma21.projekat.data.response.PitanjeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PitanjeApi {
    @GET("/kviz/{id}/pitanja")
    suspend fun getPitanja(@Path("id") idKviza: Int): List<PitanjeResponse>
}