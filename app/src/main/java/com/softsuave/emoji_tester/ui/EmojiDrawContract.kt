package com.softsuave.emoji_tester.ui

import com.softsuave.emoji_tester.model.Stroke
import com.softsuave.emoji_tester.mvp.MVP

interface EmojiDrawContract {
    interface View : MVP.View {

        fun onGuessesReturned(strings: List<String>)

        fun setEmojiToDraw(emoji: String, emojiDescription: String)

        fun onEmojiDrawnCorrectly(emoji: String)

        fun onAllEmojisDrawn()

        fun onAllEmojisDrawnWithCheat()

        fun onTimeOut()

        fun showErrorMessage()
    }

    interface Presenter : MVP.Presenter<View> {

        fun onStrokeAdded(strokes: List<Stroke>)

        fun onTimeExpired()

        fun onSkip()

    }
}