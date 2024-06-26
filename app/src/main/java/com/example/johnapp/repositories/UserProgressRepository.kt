package com.example.johnapp.repositories

import UserProgress
import com.example.johnapp.database.AppDatabase

class UserProgressRepository(private val db: AppDatabase) {
    private val userProgressDao = db.userProgressDao()

    suspend fun insertUserProgress(userProgress: UserProgress) {
        userProgressDao.insertUserProgress(userProgress)
    }

    suspend fun getUserProgressById(id: Int): UserProgress? {
        return userProgressDao.getUserProgressById(id)
    }

    suspend fun getAllUserProgress(): List<UserProgress> {
        return userProgressDao.getAllUserProgress()
    }

    suspend fun deleteUserProgress(userProgress: UserProgress) {
        userProgressDao.deleteUserProgress(userProgress)
    }
}
