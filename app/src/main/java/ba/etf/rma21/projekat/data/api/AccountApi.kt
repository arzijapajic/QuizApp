package ba.etf.rma21.projekat.data.api

import ba.etf.rma21.projekat.data.response.StudentResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface AccountApi {

    @GET("student/{id}")
    suspend fun dajStudenta(@Path("id") hashStudenta: String): StudentResponse

    @DELETE("student/{id}/upisugrupeipokusaji")
    suspend fun deleteAllGroupsForStudent(@Path("id") hashStudenta: String): String
}