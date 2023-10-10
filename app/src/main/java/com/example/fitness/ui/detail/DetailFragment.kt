package com.example.fitness.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.fitness.databinding.FragmentDetailBinding
import com.example.fitness.ui.NavigationViewModel
import com.example.fitness.ui.category.CategoryViewModel
import com.example.fitness.util.Navigation
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private val detailViewModel: DetailViewModel by activityViewModels()
    private val categoryViewModel: CategoryViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        lifecycleScope.launch {
            detailViewModel.stateLesson.collect {
                if (it != null) {
                    binding.tvDetailTime.setText(it.time)
                    binding.tvDetailDescription.setText(it.description)
                    binding.tvDetailTitle.setText(it.title)
                    binding.imageView9.setImageResource(it.full_image)
                }
            }
        }
        binding.btnDetailBack.setOnClickListener {
            if (categoryViewModel.stateCategory.value == null)
                navigationViewModel.loadState(Navigation.HOME)
            else
                navigationViewModel.loadState(Navigation.CATEGORY)
        }
        return binding.root
    }

}