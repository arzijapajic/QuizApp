package ba.etf.rma21.projekat.data.api

import ba.etf.rma21.projekat.data.response.OdgovorResponse
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface OdgovoriApi {

    @GET("/student/{id}/kviztaken/{ktid}/odgovori")
    suspend fun dajOdgovoriResult(@Path("id") hashStudenta: String, @Path("ktid") idPokusaj: Int): List<OdgovorResponse>

    @POST("/student/{id}/kviztaken/{ktid}/odgovor")
    suspend fun dajDodajOdgovor(@Path("id") hashStudenta: String, @Path("ktid") idPokusaj: Int,
                                @Field("odgovor") odgovor:Int,
                                @Field("pitanje") pitanje:Int): Int
}