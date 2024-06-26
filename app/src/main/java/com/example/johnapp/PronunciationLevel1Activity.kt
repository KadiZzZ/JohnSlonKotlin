package com.example.johnapp

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.io.IOException

class PronunciationLevel1Activity : AppCompatActivity() {

    private lateinit var textViewObjectName: TextView
    private lateinit var textViewObjectTranslation: TextView
    private lateinit var buttonListen: Button
    private lateinit var imageViewObject: ImageView
    private var mediaPlayer: MediaPlayer? = null

    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pronunciation)

        imageViewObject = findViewById(R.id.imageViewObject)
        textViewObjectName = findViewById(R.id.textViewObjectName)
        textViewObjectTranslation = findViewById(R.id.textViewObjectTranslation)
        buttonListen = findViewById(R.id.buttonListen)


        imageViewObject.setImageResource(R.drawable.horse)
        textViewObjectName.text = getString(R.string.horse_russian)
        textViewObjectTranslation.text = getString(R.string.horse_english)

        buttonListen.setOnClickListener {
            synthesizeSpeech("${textViewObjectName.text}, ${textViewObjectTranslation.text}")
        }
    }

    private fun synthesizeSpeech(text: String) {
        val url = "https://tts.api.cloud.yandex.net/speech/v1/tts:synthesize"
        val apiKey = "y0_AgAEA7qjM_V4AATuwQAAAAEHUn2cAAA_b34nrTlBU6QF4xK6A3ECpvQz0A"

        val formBody = FormBody.Builder()
            .add("text", text)
            .add("lang", "eng-ENG")
            .add("voice", "oksana")
            .add("format", "lpcm")

        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Api-Key $.api.cloud.yandex.net/speech/v1/stt:recognize")
            .post(formBody)
            .build()

        client.run {
            newCall(request).enqueue(object : Callback() {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        response.body.let { responseBody ->
                            val audioData = responseBody.bytes()
                            playAudio(audioData)
                        }
                    }
                }
            })
        }
    }

    private fun playAudio(audioData: ByteArray) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer().apply {
            setDataSource(audioData.inputStream().fd)
            prepare()
            start()
        }
    }









    override fun onDestroy() {
        mediaPlayer?.release()
        super.onDestroy()
    }
}

private fun Any.bytes(): ByteArray {

}

class Response {

    lateinit var body: Any
    val isSuccessful: Boolean
}

class Call {

}

open class Callback {

    open fun onFailure(call: Call, e: IOException) {}
    open fun onResponse(call: Call, response: Any) {}
    open fun onResponse(call: Call, response: Response) {}
}

private fun Any.enqueue(any: Any) {
    TODO("Not yet implemented")
}

private fun Any.build(): Any {
    TODO("Not yet implemented")
}

private fun Any.post(formBody: Any): Any {
    TODO("Not yet implemented")
}

private fun Any.addHeader(s: String, s1: String): Any {

}

class Request {
    class Builder {
        fun url(url: String): Any {
            TODO("Not yet implemented")
        }

    }

}

private fun Any.add(s: String, text: String): Any {
    TODO("Not yet implemented")
}

class FormBody {
    companion object {
        fun Builder(): Any {
            TODO("Not yet implemented")
        }
    }

}

