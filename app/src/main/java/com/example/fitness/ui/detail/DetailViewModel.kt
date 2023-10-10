package com.example.fitness.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitness.domain.LessonCardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val _stateLesson = MutableStateFlow<LessonCardModel?>(null)
    val stateLesson: StateFlow<LessonCardModel?> = _stateLesson
    fun loadState(lesson: LessonCardModel) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateLesson.emit(lesson)
        }
    }
}