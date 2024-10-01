package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.models.Stories
import com.example.myapplication.models.storyData
import kotlinx.coroutines.flow.MutableStateFlow

class StoryViewModel:ViewModel() {

    private var _listSize = MutableStateFlow<Int>( storyData.storyList.size )
    val listSize : MutableStateFlow<Int> get() = _listSize

    private var _isPaused = MutableStateFlow<Boolean>(false)
    val isPaused : MutableStateFlow<Boolean> get() = _isPaused

    private var _index = MutableStateFlow<Int>(0)
    val index : MutableStateFlow<Int> get() = _index

    private var _time = 5
    val time : MutableStateFlow<Int> get() = _index


    fun leftSwipe(){
        _index.value --
    }

    fun rightSwipe(){
        _index.value ++
    }
}