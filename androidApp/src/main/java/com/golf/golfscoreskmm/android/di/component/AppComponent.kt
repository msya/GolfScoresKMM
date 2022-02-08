package com.golf.golfscoreskmm.android.di.component

import android.app.Application
import androidx.compose.foundation.ExperimentalFoundationApi
import com.golf.golfscoreskmm.android.MainActivity
import com.golf.golfscoreskmm.android.di.scopes.AppScope
import com.golf.golfscoreskmm.android.di.scopes.SingleIn
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

@ExperimentalFoundationApi
@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(activity: MainActivity)
}
