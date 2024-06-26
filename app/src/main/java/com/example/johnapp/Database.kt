package com.example.johnapp.database

import Answer
import Hint
import Level
import Module
import Question
import User
import UserProgress
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.johnapp.DAO.AnswerDao
import com.example.johnapp.DAO.HintDao
import com.example.johnapp.DAO.LevelDao
import com.example.johnapp.DAO.ModuleDao
import com.example.johnapp.DAO.QuestionDao
import com.example.johnapp.DAO.UserDao
import com.example.johnapp.DAO.UserProgressDao

@Database(
    entities = [
        User::class,
        Module::class,
        Level::class,
        Question::class,
        Answer::class,
        Hint::class,
        UserProgress::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun moduleDao(): ModuleDao
    abstract fun levelDao(): LevelDao
    abstract fun questionDao(): QuestionDao
    abstract fun answerDao(): AnswerDao
    abstract fun hintDao(): HintDao
    abstract fun userProgressDao(): UserProgressDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                instance = newInstance
                newInstance
            }
        }
    }
}
