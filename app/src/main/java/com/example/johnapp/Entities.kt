import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "user_name") val userName: String
)

@Entity(tableName = "Modules")
data class Module(
    @PrimaryKey(autoGenerate = true) val moduleId: Int,
    @ColumnInfo(name = "module_name") val moduleName: String,
    @ColumnInfo(name = "module_description") val moduleDescription: String
)

@Entity(
    tableName = "Levels",
    foreignKeys = [ForeignKey(
        entity = Module::class,
        parentColumns = arrayOf("moduleId"),
        childColumns = arrayOf("module_id"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Level(
    @PrimaryKey(autoGenerate = true) val levelId: Int,
    @ColumnInfo(name = "module_id") val moduleId: Int,
    @ColumnInfo(name = "level_name") val levelName: String,
    @ColumnInfo(name = "level_description") val levelDescription: String
)

@Entity(
    tableName = "Questions",
    foreignKeys = [ForeignKey(
        entity = Level::class,
        parentColumns = arrayOf("levelId"),
        childColumns = arrayOf("level_id"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Question(
    @PrimaryKey(autoGenerate = true) val questionId: Int,
    @ColumnInfo(name = "level_id") val levelId: Int,
    @ColumnInfo(name = "question_text") val questionText: String,
    @ColumnInfo(name = "question_order") val questionOrder: Int
)

@Entity(
    tableName = "Answers",
    foreignKeys = [ForeignKey(
        entity = Question::class,
        parentColumns = arrayOf("questionId"),
        childColumns = arrayOf("question_id"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Answer(
    @PrimaryKey(autoGenerate = true) val answerId: Int,
    @ColumnInfo(name = "question_id") val questionId: Int,
    @ColumnInfo(name = "answer_text") val answerText: String,
    @ColumnInfo(name = "is_correct") val isCorrect: Boolean
)

@Entity(
    tableName = "Hints",
    foreignKeys = [ForeignKey(
        entity = Question::class,
        parentColumns = arrayOf("questionId"),
        childColumns = arrayOf("question_id"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Hint(
    @PrimaryKey(autoGenerate = true) val hintId: Int,
    @ColumnInfo(name = "question_id") val questionId: Int,
    @ColumnInfo(name = "hint_text") val hintText: String
)

@Entity(
    tableName = "UserProgress",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("user_id"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Level::class,
            parentColumns = arrayOf("levelId"),
            childColumns = arrayOf("level_id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class UserProgress(
    @PrimaryKey(autoGenerate = true) val progressId: Int,
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "level_id") val levelId: Int,
    @ColumnInfo(name = "progress") val progress: Int
)
