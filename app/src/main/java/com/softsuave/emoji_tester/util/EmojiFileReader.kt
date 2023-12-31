package com.softsuave.emoji_tester.util

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.softsuave.emoji_tester.model.Emoji
import java.io.InputStreamReader
import java.io.Reader
import javax.inject.Inject

class EmojiFileReader @Inject constructor(context: Context) {

    private val emojiList = ArrayList<Emoji>()

    init {
        context.assets.open("emoji-selected.json").use {
            val reader = InputStreamReader(it)
            val gson = GsonBuilder().create()
            emojiList.addAll(gson.fromJson(reader))
        }
    }

    inline fun <reified T> Gson.fromJson(reader: Reader) =
        this.fromJson<T>(reader, object : TypeToken<T>() {}.type)


}