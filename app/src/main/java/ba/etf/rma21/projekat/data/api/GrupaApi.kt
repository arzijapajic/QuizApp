package ba.etf.rma21.projekat.data.api

import ba.etf.rma21.projekat.data.response.DodajUGrupuResponse
import ba.etf.rma21.projekat.data.response.GrupaResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface GrupaApi {

    @GET("/grupa")
    suspend fun dajSveGrupe(): List<GrupaResponse>

    @GET("kviz/{id}/grupa")
    suspend fun dajGrupe(@Path("id") idKviza: Int): List<GrupaResponse>

    @GET("predmet/{id}/grupa")
    suspend fun dajGrupeZaPredmet(@Path("id") idPredmeta: Int): List<GrupaResponse>

    @POST("/grupa/{gid}/student/{id}")
    suspend fun dodajStudentaUGrupu(@Path("gid") idGrupe: Int,@Path("id") hashStudenta: String): DodajUGrupuResponse

    @GET("/student/{id}/grupa")
    suspend fun dajGrupeZaStudenta(@Path("id") hashStudenta: String): List<GrupaResponse>
}