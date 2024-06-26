package com.example.johnapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ParentsPageContent(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Задний фон
        Image(
            painter = painterResource(id = R.drawable.background_image_parents),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Контент
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "John-Слон",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Дорогие родители,\n\n" +
                            "Приветствуем вас в приложении \"John-Слон\" - вашем надежном помощнике в развитии навыков вашего ребенка.\n\n" +
                            "Почему \"John-Слон\"?\n\n" +
                            "\"John-Слон\" - это уникальное приложение, созданное для помощи вашему ребенку в учебе и развитии. Мы предлагаем разнообразные обучающие игры и упражнения, направленные на развитие памяти, мышления и языковых навыков.\n\n" +
                            "Что делает нас экспертами?\n\n" +
                            "Мы гордимся качественным обучением, которое предлагаем вашему ребенку. Наши материалы разработаны профессионалами с учетом потребностей детей и высоких стандартов образования.\n\n" +
                            "Присоединяйтесь к \"John-Слон\" прямо сейчас и откройте для вашего ребенка мир образования и развития!",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("main") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107), contentColor = Color.White),
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Назад")
            }
        }
    }
}
