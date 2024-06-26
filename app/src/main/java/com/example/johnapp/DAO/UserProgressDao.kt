package com.example.johnapp.DAO

import UserProgress
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserProgressDao {
    @Insert
    suspend fun insertUserProgress(userProgress: UserProgress)

    @Update
    suspend fun updateUserProgress(userProgress: UserProgress)

    @Delete
    suspend fun deleteUserProgress(userProgress: UserProgress)

    @Query("SELECT * FROM UserProgress WHERE progressId = :progressId")
    suspend fun getUserProgressById(progressId: Int): UserProgress?

    @Query("SELECT * FROM UserProgress WHERE user_id = :userId")
    suspend fun getUserProgressByUserId(userId: Int): List<UserProgress>

    @Query("SELECT * FROM UserProgress WHERE level_id = :levelId")
    suspend fun getUserProgressByLevelId(levelId: Int): List<UserProgress>
    abstract fun getAllUserProgress(): List<UserProgress>
}
