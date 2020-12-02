package pw.kozhanov.rxjava.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pw.kozhanov.rxjava.data.model.entity.CountryEntity
import pw.kozhanov.rxjava.data.remote.CountriesRepository
import pw.kozhanov.rxjava.utils.SingleLiveEvent


class CountriesListViewModel(countriesRepository: CountriesRepository) : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val countries = MutableLiveData<List<CountryEntity>>()
    val error = SingleLiveEvent<String>()

    init {
        compositeDisposable.add(countriesRepository.updateCountries())
        compositeDisposable.add(
            countriesRepository.getCountries()
                .subscribeOn(Schedulers.io())
                .subscribe({ countriesFromDB -> countries.postValue(countriesFromDB) },
                    { readError -> error.postValue(readError.message) })
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}