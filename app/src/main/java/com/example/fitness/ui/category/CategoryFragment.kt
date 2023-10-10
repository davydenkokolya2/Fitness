package com.example.fitness.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness.R
import com.example.fitness.databinding.FragmentCategoryBinding
import com.example.fitness.domain.LessonCardModel
import com.example.fitness.ui.NavigationViewModel
import com.example.fitness.ui.detail.DetailViewModel
import com.example.fitness.util.Navigation
import kotlinx.coroutines.launch

class CategoryFragment : Fragment() {
    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private val categoryViewModel: CategoryViewModel by activityViewModels()
    private val detailViewModel: DetailViewModel by activityViewModels()
    private lateinit var binding: FragmentCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)

        val layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvCategoryLessons.layoutManager = layoutManager

        lifecycleScope.launch {
            categoryViewModel.stateCategory.collect {
                if (it != null) {
                    binding.tvCategoryTitle.setText(it.title)
                    binding.tvCategoryTitleCommon.setText(it.title)
                    binding.tvCategoryLessons.text = it.list.size.toString() + " " + getString(R.string.lessons)
                    binding.rvCategoryLessons.adapter = LessonViewAdapter(it.list, ::onClick)
                }
            }
        }
        binding.btnCategoryBack.setOnClickListener {
            navigationViewModel.loadState(Navigation.HOME)
        }
        return binding.root
    }

    private fun onClick(position: Int, list: List<LessonCardModel>) {
        detailViewModel.loadState(list[position])
        navigationViewModel.loadState(Navigation.DETAIL)
    }
}