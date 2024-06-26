import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class QuizDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createModulesTable = """
            CREATE TABLE Modules (
                ModuleID INTEGER PRIMARY KEY,
                ModuleName TEXT,
                ModuleDescription TEXT
            )
        """.trimIndent()

        val createLevelsTable = """
            CREATE TABLE Levels (
                LevelID INTEGER PRIMARY KEY,
                ModuleID INTEGER,
                LevelName TEXT,
                LevelDescription TEXT,
                FOREIGN KEY(ModuleID) REFERENCES Modules(ModuleID)
            )
        """.trimIndent()

        val createQuestionsTable = """
            CREATE TABLE Questions (
                QuestionID INTEGER PRIMARY KEY,
                LevelID INTEGER,
                QuestionText TEXT,
                QuestionOrder INTEGER,
                FOREIGN KEY(LevelID) REFERENCES Levels(LevelID)
            )
        """.trimIndent()

        val createAnswersTable = """
            CREATE TABLE Answers (
                AnswerID INTEGER PRIMARY KEY,
                QuestionID INTEGER,
                AnswerText TEXT,
                IsCorrect INTEGER,
                FOREIGN KEY(QuestionID) REFERENCES Questions(QuestionID)
            )
        """.trimIndent()

        db.execSQL(createModulesTable)
        db.execSQL(createLevelsTable)
        db.execSQL(createQuestionsTable)
        db.execSQL(createAnswersTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Modules")
        db.execSQL("DROP TABLE IF EXISTS Levels")
        db.execSQL("DROP TABLE IF EXISTS Questions")
        db.execSQL("DROP TABLE IF EXISTS Answers")
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "quiz.db"
        private const val DATABASE_VERSION = 1
    }
}
