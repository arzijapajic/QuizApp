package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.response.StudentResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object AccountRepository {
    var acHash: String = "c5e265d5-0684-4f23-9572-95e2131ffe40"

    private val accountApi = ApiConfig.dajAccountApi()

    fun postaviHash(acHash:String): Boolean {
        this.acHash = acHash
        return true
    }

    fun getHash() : String = acHash

    suspend fun dajStudenta():StudentResponse {
        return accountApi.dajStudenta(acHash)
    }
}