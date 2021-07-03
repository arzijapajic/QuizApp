package ba.etf.rma21.projekat.data.api

import ba.etf.rma21.projekat.data.response.KvizResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface KvizApi {

    @GET("/kviz")
    suspend fun dajSveKvizove(): List<KvizResponse>

    @GET("/kviz/{id}")
    suspend fun dajKvizoveId(@Path("id") idKviza: Int): KvizResponse

    @GET("/grupa/{id}/kvizovi")
    suspend fun dajKvizoveGrupaId(@Path("id") idGrupa: Int): List<KvizResponse>
}