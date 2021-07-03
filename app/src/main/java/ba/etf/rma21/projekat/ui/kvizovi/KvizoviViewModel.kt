package ba.etf.rma21.projekat.ui.kvizovi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.repositories.KvizRepository
import kotlinx.coroutines.launch

class KvizoviViewModel: ViewModel() {
    private val repository = KvizRepository

    val kvizovi = MutableLiveData<List<Kviz>>()




    fun setFilterType(type: FilterType) {
        
        viewModelScope.launch {

            when (type) {

                FilterType.SVI_MOJI_KVIZOVI -> {
                    kvizovi.value = repository.getMyKvizes()
                }
                FilterType.SVI_KVIZOVI -> {
                    kvizovi.value = repository.getAll()
                }
                FilterType.URADENI_KVIZOVI -> {
                    kvizovi.value = repository.getDone()
                }
                FilterType.BUDUCI_KVIZOVI -> {
                    kvizovi.value = repository.getFuture()
                }
                FilterType.PROSLI_KVIZOVI -> {
                    kvizovi.value = repository.getNotTaken()
                }
            }
        }
    }

    enum class FilterType {
        SVI_MOJI_KVIZOVI, SVI_KVIZOVI, URADENI_KVIZOVI, BUDUCI_KVIZOVI, PROSLI_KVIZOVI
    }
}