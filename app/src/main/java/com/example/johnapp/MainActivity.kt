package com.example.johnapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController, startDestination = "main") {
                composable("main") {
                    MainScreen(navController)
                }
                composable("find_and_remember_levels") {
                    FindAndRememberLevelsScreen(navController)
                }
                composable("activity_find_and_remember_level_1") {
                    FindAndRememberLevel1Activity(navController)
                }
                composable("quiz_levels") {
                    QuizLevelsScreen(navController)
                }
                composable("pronunciation_levels") {
                    PronunciationLevelsScreen(navController)
                }
                composable("for_parents") {
                    ParentsPageContent(navController)
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(navController, "Найди и запомни", "find_and_remember_levels")
            CustomButton(navController, "Викторина", "quiz_levels")
            CustomButton(navController, "Произношение", "pronunciation_levels")
            CustomButton(navController, "Родителям", "for_parents")
        }
    }
}

@Composable
fun CustomButton(navController: NavHostController, text: String, destination: String) {
    Button(
        onClick = { navController.navigate(destination) },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107), contentColor = Color.White),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(200.dp)
    ) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen(navController = rememberNavController())
}
