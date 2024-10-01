package com.example.myapplication.models

import com.example.myapplication.R
import com.example.myapplication.models.type1.StoryType1
import com.example.myapplication.models.type2.StoryType2

data class Stories(
    val storyList: List<Story>
)

val storyData = Stories(

    storyList = listOf(
        StoryType1("1",R.drawable.pic1,  1,"AAAA" ),
        StoryType1("1",R.drawable.pic2,  2,"BBBB"),
        StoryType2("2",R.drawable.pic3,  3,"CCCC"),
        StoryType2("3",R.drawable.pic4,  4,"DDDD"),
    )
)

