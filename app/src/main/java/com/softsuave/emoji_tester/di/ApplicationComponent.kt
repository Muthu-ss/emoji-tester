package com.softsuave.emoji_tester.di

import dagger.Component
import com.softsuave.emoji_tester.di.DrawEmoji.DrawEmojiComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class), (ServiceModule::class)])
interface ApplicationComponent {

    fun plusDrawEmojiComponent(): DrawEmojiComponent

}
