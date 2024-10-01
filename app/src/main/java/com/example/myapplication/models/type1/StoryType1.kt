package com.example.myapplication.models.type1

import com.example.myapplication.models.Story

data class StoryType1(
    val type: String,
    override val picture : Int,
    override val id: Int,
    override val description: String

): Story {


}
