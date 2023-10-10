package com.example.fitness.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitness.domain.CategoryCardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    private val _stateCategory = MutableStateFlow<CategoryCardModel?>(null)
    val stateCategory: StateFlow<CategoryCardModel?> = _stateCategory
    fun loadState(category: CategoryCardModel) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateCategory.emit(category)
        }
    }
}