package com.example.fitness.util

import com.example.fitness.R
import com.example.fitness.domain.CategoryCardModel
import com.example.fitness.domain.LessonCardModel

object Constant {
    val categoriesList: List<CategoryCardModel>
        get() = listOf(
            CategoryCardModel(
                R.string.category_1,
                R.drawable.icon_category_1,
                this.gymnasticList,
            ),
            CategoryCardModel(
                R.string.category_2,
                R.drawable.icon_category_2,
                this.aerobicList,
            ),
            CategoryCardModel(
                R.string.category_3,
                R.drawable.icon_category_3,
                this.meditationList,
            ),
            CategoryCardModel(
                R.string.category_4,
                R.drawable.icon_category_4,
                this.yogaList,
            ),
        )

    val gymnasticList = listOf(
        LessonCardModel(
            R.string.gymnastics_title_1,
            R.string.time,
            R.string.indoor,
            R.string.gymnastics_description_1,
            R.drawable.icon_gymnastic_1,
            R.drawable.icon_gymnastic_full_image_1,
        ),
        LessonCardModel(
            R.string.gymnastics_title_2,
            R.string.time,
            R.string.indoor,
            R.string.gymnastics_description_2,
            R.drawable.icon_gymnastic_2,
            R.drawable.icon_gymnastic_full_image_2,
        ),
        LessonCardModel(
            R.string.gymnastics_title_3,
            R.string.time,
            R.string.indoor,
            R.string.gymnastics_description_3,
            R.drawable.icon_gymnastic_3,
            R.drawable.icon_gymnastic_full_image_3,
        ),
    )
    val aerobicList = listOf(
        LessonCardModel(
            R.string.aerobic_title_1,
            R.string.time,
            R.string.indoor,
            R.string.aerobic_description_1,
            R.drawable.icon_aerobic_1,
            R.drawable.icon_aerobic_full_image_1,
        ),
        LessonCardModel(
            R.string.aerobic_title_2,
            R.string.time,
            R.string.indoor,
            R.string.aerobic_description_2,
            R.drawable.icon_aerobic_2,
            R.drawable.icon_aerobic_full_image_2,
        ),
        LessonCardModel(
            R.string.aerobic_title_3,
            R.string.time,
            R.string.indoor,
            R.string.aerobic_description_3,
            R.drawable.icon_aerobic_3,
            R.drawable.icon_aerobic_full_image_3,
        ),
    )
    val meditationList = listOf(
        LessonCardModel(
            R.string.meditation_title_1,
            R.string.time,
            R.string.indoor,
            R.string.meditation_description_1,
            R.drawable.icon_meditation_1,
            R.drawable.icon_meditation_full_image_1,
        ),
        LessonCardModel(
            R.string.meditation_title_2,
            R.string.time,
            R.string.indoor,
            R.string.meditation_description_2,
            R.drawable.icon_meditation_2,
            R.drawable.icon_meditation_full_image_2,
        ),
    )
    val yogaList = listOf(
        LessonCardModel(
            R.string.yoga_title_1,
            R.string.time,
            R.string.indoor,
            R.string.yoga_description_1,
            R.drawable.icon_yoga_1,
            R.drawable.icon_yoga_full_image_1,
        ),
        LessonCardModel(
            R.string.yoga_title_2,
            R.string.time,
            R.string.indoor,
            R.string.yoga_description_2,
            R.drawable.icon_yoga_2,
            R.drawable.icon_yoga_full_image_2,
        ),
    )
}