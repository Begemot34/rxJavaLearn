package pw.kozhanov.rxjava.di

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pw.kozhanov.rxjava.data.local.RxExampleDatabase
import pw.kozhanov.rxjava.data.remote.CountriesRepository
import pw.kozhanov.rxjava.data.remote.NetworkService
import pw.kozhanov.rxjava.data.remote.RestcountriesApi
import pw.kozhanov.rxjava.data.remote.provideRetrofit
import pw.kozhanov.rxjava.ui.CountriesListViewModel

val appModule = module {
    single { getDatabase(androidApplication()) }
}

val apiModule = module {
    single { provideRetrofit() }
    single { NetworkService(get()) }
    //api endpoints
    single { provideCountriesAPI(get()) }

    factory { CountriesRepository(get(), get()) }
}

val viewModelsModule = module {
    viewModel { CountriesListViewModel(get()) }
}

private fun getDatabase(androidApplication: Application): RxExampleDatabase {
    return Room.databaseBuilder(
        androidApplication,
        RxExampleDatabase::class.java,
        "project-db"
    ).build()
}

private fun provideCountriesAPI(networkService: NetworkService): RestcountriesApi {
    return networkService.getRestCountriesService()
}