package ba.etf.rma21.projekat.data.api

import ba.etf.rma21.projekat.data.response.KvizTakenResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface KvizTakenApi {
    @GET("/student/{id}/kviztaken")
    suspend fun dajListuPokusaja(@Path("id") hashStudenta: String): List<KvizTakenResponse>

    @POST("/student/{id}/kviz/{kid}")
    suspend fun zapocniOdgovaranje(@Path("id") hashStudenta: String, @Path("kid") idKviz: Int): KvizTakenResponse
}