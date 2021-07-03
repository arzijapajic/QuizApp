package ba.etf.rma21.projekat.ui.predmeti

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.repositories.GodineRepository
import ba.etf.rma21.projekat.data.repositories.PredmetIGrupaRepository
import kotlinx.coroutines.launch

class PredmetiViewModel : ViewModel() {

    private val godineRepository = GodineRepository
    private val predmetRepository = PredmetIGrupaRepository

    val godine = MutableLiveData<List<String>>()
    val predmeti = MutableLiveData<List<String>>()
    val grupe = MutableLiveData<List<String>>()

    val onUpisan = MutableLiveData<Grupa>()

    init {
        godine.value = godineRepository.dajSveGodine()
    }

    fun odaberiGodinu(godina: Int) {
        viewModelScope.launch {
            predmeti.value = predmetRepository.getPredmeti().filter { it.godina == godina }
                .map { predmet -> predmet.naziv }
        }
    }

    fun odaberiPredmet(naziv: String) {
        viewModelScope.launch {
            predmetRepository.getPredmeti().find { it.naziv == naziv }?.let {
                grupe.value =
                    predmetRepository.getGrupeZaPredmet(it.id).map { grupa -> grupa.naziv }
            }
        }
    }

    fun upisiNaGrupu(grupa: Grupa) {
        viewModelScope.launch {
            val grupe = predmetRepository.getGrupe()
            grupe.find { it.naziv == grupa.naziv }?.let {
                predmetRepository.upisiUGrupu(it.id)
                onUpisan.value = grupa
            }
        }
    }
}