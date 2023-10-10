package com.example.fitness.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.fitness.R
import com.example.fitness.ui.category.CategoryFragment
import com.example.fitness.ui.detail.DetailFragment
import com.example.fitness.ui.home.HomeFragment
import com.example.fitness.ui.onboarding.OnboardingFragment
import com.example.fitness.util.Navigation
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val navigationViewModel: NavigationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            navigationViewModel.stateNavigation.collect {
                when(it) {
                    Navigation.HOME -> replaceFragment(HomeFragment())
                    Navigation.ONBOARDING -> replaceFragment(OnboardingFragment())
                    Navigation.DETAIL -> replaceFragment(DetailFragment())
                    Navigation.CATEGORY -> replaceFragment(CategoryFragment())
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}