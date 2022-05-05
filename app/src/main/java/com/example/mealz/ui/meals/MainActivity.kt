package com.example.mealz.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealz.model.response.MealsResponse
import com.example.mealz.ui.theme.MealzTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

@Composable
fun MealsCategoriesScreen() {
    //val viewModel = MealsCategoriesViewModel()
    //special syntax, the view model should be type of MealsCategoriesViewModel.
    //It will live as long as this composable lives
    val viewModel : MealsCategoriesViewModel = viewModel()
    val rememberedMeals : MutableState<List<MealsResponse>> = remember {
        mutableStateOf(emptyList<MealsResponse>())
    }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = "GET_MEALS"){
        coroutineScope.launch(Dispatchers.IO) {
            val meals = viewModel.getMeals()
            rememberedMeals.value = meals
        }
    }

    LazyColumn {
        items(rememberedMeals.value) {
            meal ->  Text(text = "${meal.name}")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzTheme {
        MealsCategoriesScreen()
    }
}