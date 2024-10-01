package com.example.myapplication.models.type2

import com.example.myapplication.models.Story

data class StoryType2(
    val type: String,
    override val picture : Int,
    override val id: Int,
    override val description: String
): Story {


}
