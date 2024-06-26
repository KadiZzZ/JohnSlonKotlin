package com.example.johnapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHostController

class FindAndRememberLevel1Activity(navController: NavHostController) : AppCompatActivity() {

    private lateinit var backgroundImageView: ImageView
    private lateinit var cowImageView: ImageView
    private lateinit var chickenImageView: ImageView
    private lateinit var objectInfoCardView: androidx.cardview.widget.CardView
    private lateinit var objectNameTextView: TextView
    private lateinit var objectTranslationTextView: TextView
    private lateinit var closeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_and_remember_level_1)

        // Initialize views
        backgroundImageView = findViewById(R.id.backgroundImageView)
        cowImageView = findViewById(R.id.cowImageView)
        chickenImageView = findViewById(R.id.chickenImageView)
        objectInfoCardView = findViewById(R.id.objectInfoCardView)
        objectNameTextView = findViewById(R.id.objectNameTextView)
        objectTranslationTextView = findViewById(R.id.objectTranslationTextView)
        closeButton = findViewById(R.id.closeButton)

        // Set onClickListener for cowImageView
        cowImageView.setOnClickListener {
            showObjectInfo("Cow", getString(R.string.cow_translation))
        }

        // Set onClickListener for chickenImageView
        chickenImageView.setOnClickListener {
            showObjectInfo("Chicken", getString(R.string.chicken_translation))
        }

        // Set onClickListener for closeButton
        closeButton.setOnClickListener {
            hideObjectInfo()
        }
    }

    private fun showObjectInfo(objectName: String, translation: String) {
        objectNameTextView.text = objectName
        objectTranslationTextView.text = translation
        objectInfoCardView.visibility = android.view.View.VISIBLE
    }

    private fun hideObjectInfo() {
        objectInfoCardView.visibility = android.view.View.GONE
    }
}
