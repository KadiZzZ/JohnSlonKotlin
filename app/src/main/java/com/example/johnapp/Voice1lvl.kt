package com.example.johnapp

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.johnapp.R.id.speak_button
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class PronunciationActivity : AppCompatActivity() {

    private val apiKey = "y0_AgAEA7qjM_V4AATuwQAAAAEHUn2cAAA_b34nrTlBU6QF4xK6A3ECpvQz0A"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pronunciation)

        val speakButton: Button = findViewById(speak_button)
        speakButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                val text = "Horse"
                val voice = "oksana"
                synthesizeAndPlay(text, voice, 1.0f)
                synthesizeAndPlay(text, voice, 0.8f)
            }
        }
    }

    private suspend fun synthesizeAndPlay(text: String, voice: String, speed: Float) {
        val audioData = synthesizeSpeech(text, voice, speed)
        audioData?.let {
            withContext(Dispatchers.Main) {
                playAudio(it)
            }
        }
    }

    private fun synthesizeSpeech(text: String, voice: String, speed: Float): ByteArray? {
        val url = URL("https://tts.api.cloud.yandex.net/speech/v1/tts:synthesize")
        val postData = "text=$text&voice=$voice&speed=$speed&format=lpcm&sampleRateHertz=48000"
        val connection = url.openConnection() as HttpURLConnection
        return try {
            connection.apply {
                requestMethod = "POST"
                doOutput = true
                setRequestProperty("Authorization", "Api-Key $apiKey")
                setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
                outputStream.write(postData.toByteArray())
            }
            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                connection.inputStream.readBytes()
            } else {
                null
            }
        } finally {
            connection.disconnect()
        }
    }

    private fun playAudio(audioData: ByteArray) {
        val tempFile = createTempFile(suffix = ".pcm")
        tempFile.writeBytes(audioData)

        val mediaPlayer = MediaPlayer()
        mediaPlayer.apply {
            setDataSource(tempFile.absolutePath)
            setOnPreparedListener { start() }
            prepareAsync()
            setOnCompletionListener { reset() }
        }
    }
}
