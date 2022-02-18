package com.example.lyricsnake

import javax.inject.Inject

class HiltTest @Inject constructor() {
    fun getHiltText():String{
        return "hilt"
    }
}