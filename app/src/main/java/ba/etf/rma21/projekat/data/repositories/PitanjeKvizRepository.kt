package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.Pitanje
import ba.etf.rma21.projekat.data.response.PitanjeResponse


object PitanjeKvizRepository {

    suspend fun getPitanja(idKviza: Int): List<PitanjeResponse> {
        return ApiConfig.dajPitanjaApi().dajPitanjaId(idKviza)
    }
}