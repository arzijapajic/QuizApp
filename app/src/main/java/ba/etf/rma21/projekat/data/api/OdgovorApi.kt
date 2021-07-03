package ba.etf.rma21.projekat.data.api

import Odgovor
import ba.etf.rma21.projekat.data.response.OdgovorRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface OdgovorApi {
    @GET("/student/{id}/kviztaken/{ktid}/odgovori")
    suspend fun getOdgovoriKviz(@Path("id") hashStudenta: String, @Path("ktid") idKviz: Int):  List<Odgovor>

    @POST("/student/{id}/kviztaken/{ktid}")
    suspend fun postaviOdgovorKviz(
        @Path("id") hashStudenta: String,
        @Path("ktid") idKviz: Int,
        @Body odgovorRequest: OdgovorRequest
    ):  Odgovor
}