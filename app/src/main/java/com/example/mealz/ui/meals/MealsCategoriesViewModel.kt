package com.example.mealz.ui.meals

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealz.model.MealsRepository
import com.example.mealz.model.response.MealsResponse
import kotlinx.coroutines.*

//Presentation Logic - Data should be ready to be displayed. Sent or fetched by actual view
class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    val mealsState : MutableState<List<MealsResponse>> = mutableStateOf(emptyList<MealsResponse>())


    private suspend fun getMeals(): List<MealsResponse> {
        return repository.getMeals().categories
    }
}