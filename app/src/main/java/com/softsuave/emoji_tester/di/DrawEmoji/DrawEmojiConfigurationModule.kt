package com.softsuave.emoji_tester.di.DrawEmoji

import dagger.Module
import dagger.Provides
import com.softsuave.emoji_tester.di.ActivityScope

@Module
object DrawEmojiConfigurationModule {

    @Provides
    @JvmStatic
    @ActivityScope
    fun providePracticeSize(): Int {
        return 10
    }
}