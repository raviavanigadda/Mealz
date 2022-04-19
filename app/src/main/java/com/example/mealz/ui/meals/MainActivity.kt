package com.example.mealz.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealz.ui.theme.MealzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzTheme {
                // A surface container using the 'background' color from the theme
                MealsCategoriesScreen()
            }
        }
    }
}

@Composable
fun MealsCategoriesScreen() {
    //val viewModel = MealsCategoriesViewModel()
    //special syntax, the view model should be type of MealsCategoriesViewModel.
    //It will live as long as this composable lives
    val viewModel : MealsCategoriesViewModel = viewModel()

    Text(text = "Hello Compose!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzTheme {
        MealsCategoriesScreen()
    }
}