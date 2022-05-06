package com.example.mealz.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mealz.ui.meals.MealsCategoriesScreen
import com.example.mealz.ui.theme.MealzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val viewModel by viewModels<MealsCategoriesViewModel>()
        //we dont want the view model to be tied to activity but to composable
        setContent {
            MealzTheme {
                // A surface container using the 'background' color from the theme
                MealsCategoriesScreen()
            }
        }
    }
}
