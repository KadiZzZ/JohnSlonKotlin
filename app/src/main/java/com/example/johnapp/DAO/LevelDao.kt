package com.example.johnapp.DAO

import Level
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LevelDao {
    @Insert
    suspend fun insertLevel(level: Level)

    @Update
    suspend fun updateLevel(level: Level)

    @Delete
    suspend fun deleteLevel(level: Level)

    @Query("SELECT * FROM Levels WHERE levelId = :levelId")
    suspend fun getLevelById(levelId: Int): Level?

    @Query("SELECT * FROM Levels WHERE module_id = :moduleId")
    suspend fun getLevelsByModuleId(moduleId: Int): List<Level>
    abstract fun getAllLevels(): List<Level>
}
