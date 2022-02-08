package com.golf.golfscoreskmm.android

import android.app.Application
import androidx.compose.foundation.ExperimentalFoundationApi
import com.golf.golfscoreskmm.android.di.component.ApplicationComponent
import com.golf.golfscoreskmm.android.di.component.DaggerApplicationComponent

@ExperimentalFoundationApi
class GolfScoresApp: Application() {

    companion object {
        lateinit var component: ApplicationComponent
            private set
    }

    override fun onCreate() {
        component = DaggerApplicationComponent.builder().application(this).build()
        super.onCreate()

    }
}
