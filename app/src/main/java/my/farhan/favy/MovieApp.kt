package my.farhan.favy

import android.app.Application
import my.farhan.favy.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MovieApp)
            modules(apiModule + databaseModule + viewModelModule + repositoryModule + networkModule)
        }
    }
}