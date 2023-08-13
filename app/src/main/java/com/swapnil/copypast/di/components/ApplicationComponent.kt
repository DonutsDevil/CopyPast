package com.swapnil.copypast.di.components

import android.content.Context
import com.swapnil.copypast.di.customAnnotation.ApplicationSingleton
import com.swapnil.copypast.di.module.CopyPastDBModule
import com.swapnil.copypast.ui.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [CopyPastDBModule::class])
@ApplicationSingleton
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}