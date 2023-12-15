package com.softsuave.emoji_tester.data

import com.softsuave.emoji_tester.data.EmojiToDraw

interface EmojiToDrawProvider {

    fun provide(n: Int): List<EmojiToDraw>

}