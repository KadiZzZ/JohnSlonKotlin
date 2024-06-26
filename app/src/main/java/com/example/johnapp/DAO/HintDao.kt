package com.example.johnapp.DAO

import Hint
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface HintDao {
    @Insert
    suspend fun insertHint(hint: Hint)

    @Update
    suspend fun updateHint(hint: Hint)

    @Delete
    suspend fun deleteHint(hint: Hint)

    @Query("SELECT * FROM Hints WHERE hintId = :hintId")
    suspend fun getHintById(hintId: Int): Hint?

    @Query("SELECT * FROM Hints WHERE question_id = :questionId")
    suspend fun getHintsByQuestionId(questionId: Int): List<Hint>
    abstract fun getAllHints(): List<Hint>
}
