package com.softsuave.emoji_tester.model

data class Emoji(
    val id: Int,
    val categoryId: Int,
    val emoji: String,
    val sinceVersion: Int,
    val description: String
)