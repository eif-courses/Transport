package lt.viko.eif.transport.appsas

import android.app.Application
import lt.viko.eif.transport.appsas.di.fruitModule
import lt.viko.eif.transport.appsas.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                fruitModule,
                networkModule
            )
        }
    }
}