package com.example.mealz.model

import com.example.mealz.model.response.MealsCategoriesResponse

class MealsRepository {
    fun getMeals() : MealsCategoriesResponse = MealsCategoriesResponse(arrayListOf())
}