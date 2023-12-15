package com.softsuave.emoji_tester.di.DrawEmoji

import dagger.Subcomponent
import com.softsuave.emoji_tester.di.ActivityScope
import com.softsuave.emoji_tester.mvp.EmojiDrawMvpModule
import com.softsuave.emoji_tester.ui.DrawEmojiActivity

@ActivityScope
@Subcomponent(modules = [(EmojiDrawMvpModule::class), (DrawEmojiConfigurationModule::class)])
interface DrawEmojiComponent {

    fun inject(drawEmojiActivity: DrawEmojiActivity)
}
