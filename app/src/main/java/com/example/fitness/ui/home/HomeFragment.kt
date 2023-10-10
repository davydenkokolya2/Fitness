package com.example.fitness.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness.databinding.FragmentHomeBinding
import com.example.fitness.domain.CategoryCardModel
import com.example.fitness.domain.LessonCardModel
import com.example.fitness.ui.NavigationViewModel
import com.example.fitness.ui.category.CategoryViewModel
import com.example.fitness.ui.category.LessonViewAdapter
import com.example.fitness.ui.detail.DetailViewModel
import com.example.fitness.util.Constant
import com.example.fitness.util.Navigation

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private val categoryViewModel: CategoryViewModel by activityViewModels()
    private val detailViewModel: DetailViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvHomeCategories.layoutManager = layoutManager
        binding.rvHomeCategories.adapter = CategoryViewAdapter(Constant.categoriesList, ::onClick)

        val layoutManager2 =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvHomeLessons.layoutManager = layoutManager2
        binding.rvHomeLessons.adapter = LessonViewAdapter(Constant.aerobicList, ::onClickLesson)
        return binding.root
    }

    private fun onClick(position: Int, list: List<CategoryCardModel>) {
        categoryViewModel.loadState(list[position])
        navigationViewModel.loadState(Navigation.CATEGORY)
    }

    private fun onClickLesson(position: Int, list: List<LessonCardModel>) {
        detailViewModel.loadState(list[position])
        navigationViewModel.loadState(Navigation.DETAIL)
    }
}