package pw.kozhanov.rxjava.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pw.kozhanov.rxjava.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class NetworkService(private val retrofit: Retrofit) {
    fun getRestCountriesService():RestcountriesApi {
        return retrofit.create()
    }
}

fun provideRetrofit(): Retrofit {
    val logInterceptor = HttpLoggingInterceptor()
    logInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
    val galaxyClient = OkHttpClient().newBuilder()
        .addInterceptor(logInterceptor)
        .build()

    return Retrofit.Builder()
        .client(galaxyClient)
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}