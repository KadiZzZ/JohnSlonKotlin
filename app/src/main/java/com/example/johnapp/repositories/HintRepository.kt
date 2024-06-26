package com.example.johnapp.repositories

import Hint
import com.example.johnapp.database.AppDatabase

class HintRepository(private val db: AppDatabase) {
    private val hintDao = db.hintDao()

    suspend fun insertHint(hint: Hint) {
        hintDao.insertHint(hint)
    }

    suspend fun getHintById(id: Int): Hint? {
        return hintDao.getHintById(id)
    }

    suspend fun getAllHints(): List<Hint> {
        return hintDao.getAllHints()
    }

    suspend fun deleteHint(hint: Hint) {
        hintDao.deleteHint(hint)
    }
}
