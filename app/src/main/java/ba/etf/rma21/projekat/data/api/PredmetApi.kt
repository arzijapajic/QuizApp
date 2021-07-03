package ba.etf.rma21.projekat.data.api

import ba.etf.rma21.projekat.data.response.PredmetResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PredmetApi {

    @GET("/predmet")
    suspend fun dajSvePredmete(): List<PredmetResponse>

    @GET("/predmet/{id}")
    suspend fun dajPredmet(@Path("id") id: String): PredmetResponse
}