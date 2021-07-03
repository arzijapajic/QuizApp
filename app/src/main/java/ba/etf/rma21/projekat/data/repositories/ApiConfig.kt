package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.api.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiConfig {

    var baseURL: String = "https://rma21-etf.herokuapp.com"

    val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
    val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
    private var retrofit: Retrofit
    init {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun postaviBaseURL(baseUrl: String): Unit {
        baseURL = baseUrl
        retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

     fun dajRetrofit(): Retrofit = retrofit

    fun dajAccountApi(): AccountApi {
        return dajRetrofit().create(AccountApi::class.java)
    }

    fun dajPredmetiApi(): PredmetApi {
        return dajRetrofit().create(PredmetApi::class.java)
    }

    fun dajGrupeApi(): GrupaApi {
        return dajRetrofit().create(GrupaApi::class.java)
    }

    fun dajKvizApi(): KvizApi {
        return dajRetrofit().create(KvizApi::class.java)
    }

    fun dajKvizTakenApi(): KvizTakenApi {
        return dajRetrofit().create(KvizTakenApi::class.java)
    }

    fun dajOdgovoriApi(): OdgovoriApi {
        return dajRetrofit().create(OdgovoriApi::class.java)
    }

    fun dajPitanjaApi(): PitanjaApi {
        return dajRetrofit().create(PitanjaApi::class.java)
    }
}