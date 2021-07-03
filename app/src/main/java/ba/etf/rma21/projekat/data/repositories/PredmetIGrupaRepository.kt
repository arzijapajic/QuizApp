package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.response.DodajUGrupuResponse
import ba.etf.rma21.projekat.data.response.GrupaResponse
import ba.etf.rma21.projekat.data.response.PredmetResponse


object PredmetIGrupaRepository {

    suspend fun getPredmeti(): List<PredmetResponse> {
        return ApiConfig.dajPredmetiApi().dajSvePredmete()
    }

    suspend fun getGrupe(): List<GrupaResponse> {
        return ApiConfig.dajGrupeApi().dajSveGrupe()
    }

    suspend fun getGrupeZaPredmet(idPredmeta: Int): List<GrupaResponse> {
        return ApiConfig.dajGrupeApi().dajGrupeZaPredmet(idPredmeta)
    }

    suspend fun upisiUGrupu(idGrupa: Int): DodajUGrupuResponse {
        return ApiConfig.dajGrupeApi().dodajStudentaUGrupu(idGrupa, AccountRepository.acHash)
    }

    suspend fun getUpisaneGrupe(): List<GrupaResponse> {
        return ApiConfig.dajGrupeApi().dajGrupeZaStudenta(AccountRepository.acHash)
    }
    suspend fun getPodatak(idPredmeta: Int): String?{
        val grupa=ApiConfig.dajGrupeApi().dajGrupeZaPredmet(idPredmeta);
        System.out.print("////////////////////////////////////");
        System.out.print(grupa);
       return null;


    }
}