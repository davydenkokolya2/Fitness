package com.example.fitness.domain

data class CategoryCardModel(
    val title: Int,
    val image: Int,
    var list: List<LessonCardModel>,
)
