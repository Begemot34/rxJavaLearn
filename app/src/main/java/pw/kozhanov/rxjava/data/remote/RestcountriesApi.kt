package pw.kozhanov.rxjava.data.remote

import io.reactivex.Observable
import io.reactivex.Single
import pw.kozhanov.rxjava.data.model.api.CountriesResponseItem
import retrofit2.http.GET

interface RestcountriesApi {
    @GET("all")
    fun getCountries(): Single<List<CountriesResponseItem>>
}