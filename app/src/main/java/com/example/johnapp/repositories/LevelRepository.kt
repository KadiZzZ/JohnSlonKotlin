package com.example.johnapp.repositories

import Level
import com.example.johnapp.database.AppDatabase

class LevelRepository(private val db: AppDatabase) {
    private val levelDao = db.levelDao()

    suspend fun insertLevel(level: Level) {
        levelDao.insertLevel(level)
    }

    suspend fun getLevelById(id: Int): Level? {
        return levelDao.getLevelById(id)
    }

    suspend fun getAllLevels(): List<Level> {
        return levelDao.getAllLevels()
    }

    suspend fun deleteLevel(level: Level) {
        levelDao.deleteLevel(level)
    }
}
