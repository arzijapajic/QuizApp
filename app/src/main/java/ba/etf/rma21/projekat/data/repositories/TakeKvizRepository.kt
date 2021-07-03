package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.KvizTaken
import ba.etf.rma21.projekat.data.response.KvizTakenResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object TakeKvizRepository {

    suspend fun zapocniKviz(idKviza: Int): KvizTakenResponse? {
        return ApiConfig.dajKvizTakenApi().zapocniOdgovaranje(AccountRepository.acHash, idKviza)
    }

    suspend fun getPocetiKvizovi(): List<KvizTakenResponse>? {
        val pokusaji: List<KvizTakenResponse> = withContext(Dispatchers.IO) {
            return@withContext ApiConfig.dajKvizTakenApi()
                .dajListuPokusaja(AccountRepository.acHash)
        }
        if (pokusaji.isEmpty())
            return null;
        return pokusaji;
        //   return ApiConfig.dajKvizTakenApi().dajListuPokusaja(AccountRepository.acHash)
    }
}