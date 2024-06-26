package com.example.johnapp.DAO

import Question
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuestionDao {
    @Insert
    suspend fun insertQuestion(question: Question)

    @Update
    suspend fun updateQuestion(question: Question)

    @Delete
    suspend fun deleteQuestion(question: Question)

    @Query("SELECT * FROM Questions WHERE questionId = :questionId")
    suspend fun getQuestionById(questionId: Int): Question?

    @Query("SELECT * FROM Questions WHERE level_id = :levelId")
    suspend fun getQuestionsByLevelId(levelId: Int): List<Question>
    abstract fun getAllQuestions(): List<Question>
}

