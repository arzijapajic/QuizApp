package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.api.OdgovorApi
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.KvizTaken
import ba.etf.rma21.projekat.data.response.OdgovorResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OdgovorRepository {
    companion object {

        suspend fun getOdgovoriKviz(idKviza: Int): List<OdgovorResponse>? {
            return ApiConfig.dajOdgovoriApi().dajOdgovoriResult(AccountRepository.acHash,idKviza)
        }

        suspend fun postaviOdgovorKviz(idKvizTaken: Int, idPitanje: Int, odgovor: Int): Int? {
           return ApiConfig.dajOdgovoriApi().dajDodajOdgovor(AccountRepository.acHash,idKvizTaken,odgovor,idPitanje)


    }}
}
