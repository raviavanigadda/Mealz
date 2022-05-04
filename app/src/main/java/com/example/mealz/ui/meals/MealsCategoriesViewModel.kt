package com.example.mealz.ui.meals

import androidx.lifecycle.ViewModel
import com.example.mealz.model.MealsRepository
import com.example.mealz.model.response.MealsCategoriesResponse
import com.example.mealz.model.response.MealsResponse

//Presentation Logic - Data should be ready to be displayed. Sent or fetched by actual view
class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals {
            response -> successCallback(response)
        }
    }
}