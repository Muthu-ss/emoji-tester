package com.softsuave.emoji_tester.mvp

import dagger.Binds
import dagger.Module
import dagger.Provides
import com.softsuave.emoji_tester.data.EmojiToDrawProvider
import com.softsuave.emoji_tester.di.ActivityScope
import com.softsuave.emoji_tester.ui.EmojiDrawContract
import com.softsuave.emoji_tester.ui.EmojiDrawPresenter
import com.softsuave.emoji_tester.util.FixedEmojiToDrawProvider

@Module
abstract class EmojiDrawMvpModule {

    @Binds
    @ActivityScope
    abstract fun provideEmojiDrawPresenter(presenter: EmojiDrawPresenter): EmojiDrawContract.Presenter

    @Module
    companion object {

        @Provides
        @ActivityScope
        @JvmStatic
        fun provideVersionBasedEmojiToDrawProvider(): EmojiToDrawProvider {
            return FixedEmojiToDrawProvider()
        }
    }
}
