package com.softsuave.emoji_tester.model

class Stroke {

    val xcoords = mutableListOf<Int>()
    val ycoords = mutableListOf<Int>()

    fun addPoint(x: Int, y: Int) {
        xcoords.add(x)
        ycoords.add(y)
    }
}