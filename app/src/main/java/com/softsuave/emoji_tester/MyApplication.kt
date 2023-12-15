package com.softsuave.emoji_tester

import android.app.Application
import android.content.Context
import com.softsuave.emoji_tester.di.ApplicationComponent
import com.softsuave.emoji_tester.di.ApplicationModule
import com.softsuave.emoji_tester.di.DaggerApplicationComponent

open class MyApplication : Application() {

    private lateinit var component: ApplicationComponent

    companion object {
        fun getComponent(context: Context): ApplicationComponent {
            return (context.applicationContext as MyApplication).component
        }
    }

    override fun onCreate() {
        super.onCreate()
        component = createComponent()
    }

    protected open fun createComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}