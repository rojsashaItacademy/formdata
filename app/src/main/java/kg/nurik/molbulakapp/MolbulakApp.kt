package kg.nurik.molbulakapp

import android.app.Application
import kg.nurik.molbulakapp.data.local.PreferenceHelper
import kg.nurik.molbulakapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MolbulakApp : Application() {

    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.initPreference(this)
        startKoin {
            androidContext(this@MolbulakApp)
            modules(appModules)
        }
    }
}