package com.example.johnapp.repositories

import Question
import com.example.johnapp.database.AppDatabase

class QuestionRepository(private val db: AppDatabase) {
    private val questionDao = db.questionDao()

    suspend fun insertQuestion(question: Question) {
        questionDao.insertQuestion(question)
    }

    suspend fun getQuestionById(id: Int): Question? {
        return questionDao.getQuestionById(id)
    }

    suspend fun getAllQuestions(): List<Question> {
        return questionDao.getAllQuestions()
    }

    suspend fun deleteQuestion(question: Question) {
        questionDao.deleteQuestion(question)
    }
}
