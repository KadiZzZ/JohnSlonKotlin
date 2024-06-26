package com.example.johnapp.repositories

import User
import com.example.johnapp.database.AppDatabase

class UserRepository(private val db: AppDatabase) {
    private val userDao = db.userDao()

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun getUserById(id: Int): User? {
        return userDao.getUserById(id)
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
}
