package com.swapnil.copypast

import android.app.Application
import com.swapnil.copypast.di.components.ApplicationComponent
import com.swapnil.copypast.di.components.DaggerApplicationComponent

class CopyPastApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

}