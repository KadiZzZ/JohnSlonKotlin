package com.example.johnapp.DAO

import Answer
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AnswerDao {
    @Insert
    suspend fun insertAnswer(answer: Answer)

    @Update
    suspend fun updateAnswer(answer: Answer)

    @Delete
    suspend fun deleteAnswer(answer: Answer)

    @Query("SELECT * FROM Answers WHERE answerId = :answerId")
    suspend fun getAnswerById(answerId: Int): Answer?

    @Query("SELECT * FROM Answers WHERE question_id = :questionId")
    suspend fun getAnswersByQuestionId(questionId: Int): List<Answer>
    abstract fun getAllAnswers(): List<Answer>
}
