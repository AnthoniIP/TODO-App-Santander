package ipsoft.lembretesetarefas

import android.app.Application
import ipsoft.lembretesetarefas.utils.di.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppAplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    androidModule
                )
            )
            androidContext(this@AppAplication)
        }
    }
}