package pw.kozhanov.rxjava

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import pw.kozhanov.rxjava.di.apiModule
import pw.kozhanov.rxjava.di.appModule
import pw.kozhanov.rxjava.di.viewModelsModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(appModule, apiModule, viewModelsModule)
        }
    }
}