package com.example.johnapp.repositories

import Answer
import com.example.johnapp.database.AppDatabase

class AnswerRepository(private val db: AppDatabase) {
    private val answerDao = db.answerDao()

    suspend fun insertAnswer(answer: Answer) {
        answerDao.insertAnswer(answer)
    }

    suspend fun getAnswerById(id: Int): Answer? {
        return answerDao.getAnswerById(id)
    }

    suspend fun getAllAnswers(): List<Answer> {
        return answerDao.getAllAnswers()
    }

    suspend fun deleteAnswer(answer: Answer) {
        answerDao.deleteAnswer(answer)
    }
}
