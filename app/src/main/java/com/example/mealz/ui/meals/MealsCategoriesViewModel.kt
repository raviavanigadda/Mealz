package com.example.mealz.ui.meals

import androidx.lifecycle.ViewModel
import com.example.mealz.model.MealsRepository
import com.example.mealz.model.response.MealsResponse

//Presentation Logic - Data should be ready to be displayed. Sent or fetched by actual view
class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    suspend fun getMeals(): List<MealsResponse> {
        return repository.getMeals().categories
    }
}