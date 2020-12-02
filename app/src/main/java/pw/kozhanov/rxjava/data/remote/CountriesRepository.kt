package pw.kozhanov.rxjava.data.remote

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pw.kozhanov.rxjava.data.local.RxExampleDatabase
import pw.kozhanov.rxjava.data.model.entity.CountryEntity

class CountriesRepository(
    private val networkService: NetworkService,
    private val database: RxExampleDatabase
) {
    fun updateCountries(): Disposable {
        return networkService.getRestCountriesService().getCountries()
            .subscribeOn(Schedulers.io())
            .map { response ->
                response.map { countryItem ->
                    CountryEntity(
                        countryItem.flag,
                        countryItem.name,
                        countryItem.capital,
                        countryItem.population.toString(),
                        countryItem.nativeName
                    )
                }
            }
            .subscribe(
                { result ->
                    updateCountriesInDb(result)
                },
                { error ->
                    error.printStackTrace()
                })

    }

    private fun updateCountriesInDb(countryItems: List<CountryEntity>) {
        GlobalScope.launch {
            database.countriesDAO().insertCountries(countryItems)
        }
    }

    fun getCountries() = database.countriesDAO().getCourses()
}