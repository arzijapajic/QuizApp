package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.KvizStatus
import ba.etf.rma21.projekat.data.response.KvizResponse
import ba.etf.rma21.projekat.data.response.mapToDomain
import java.text.SimpleDateFormat
import java.util.*

object KvizRepository {

    suspend fun mojiKvizovi(): List<Kviz> {
        return getUpisani()
    }

    suspend fun getMyKvizes(): List<Kviz> {
        return mojiKvizovi().sortedBy { it.datumPocetka }
    }

    suspend fun getAll(): List<Kviz> {
        return ApiConfig.dajKvizApi().dajSveKvizove().map {
            it.mapToDomain()
        }
    }

    suspend fun getDone(): List<Kviz> {
        return mojiKvizovi().sortedBy {
            it.datumPocetka
        }.filter { kviz ->
            kviz.kvizStatus == KvizStatus.DONE
        }
    }

    suspend fun getFuture(): List<Kviz> {
        return mojiKvizovi().sortedBy { it.datumPocetka }
            .filter { kviz -> kviz.kvizStatus == KvizStatus.NOT_ACTIVE }
    }

    suspend fun getNotTaken(): List<Kviz> {
        return mojiKvizovi().sortedBy { it.datumPocetka }
            .filter { kviz -> kviz.kvizStatus == KvizStatus.NOT_DONE }
    }

    suspend fun getUpisani(): List<Kviz> {
        val kvizovi = mutableSetOf<Kviz>()
        PredmetIGrupaRepository.getUpisaneGrupe().forEach {
            kvizovi.addAll(ApiConfig.dajKvizApi().dajKvizoveGrupaId(it.id).map {
                it.mapToDomain()
            })
        }
        return kvizovi.toList()
    }

    suspend fun getById(id: Int): Kviz {
        return ApiConfig.dajKvizApi().dajKvizoveId(id).let {
            it.mapToDomain()
        }
    }
}