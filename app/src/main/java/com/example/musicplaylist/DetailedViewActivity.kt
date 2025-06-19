package com.example.musicplaylist

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class DetailedViewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

                val songs = intent.getStringArrayListExtra("songs") ?: arrayListOf()
                val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
                val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
                val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

                val displayBtn = findViewById<Button>(R.id.btnDisplaySongs)
                val avgBtn = findViewById<Button>(R.id.btnAverage)
                val backBtn = findViewById<Button>(R.id.btnBack)
                val output = findViewById<TextView>(R.id.tvOutput)

                displayBtn.setOnClickListener {
                    val builder = StringBuilder()
                    for (i in songs.indices) {
                        builder.append("Song: ${songs[i]}, Artist: ${artists[i]}, Rating: ${ratings[i]}, Comment: ${comments[i]}\n")
                    }
                    output.text = builder.toString()
                }

                avgBtn.setOnClickListener {
                    if (ratings.isNotEmpty()) {
                        val avg = ratings.sum().toDouble() / ratings.size
                        output.text = "Average Rating: %.2f".format(avg)
                    } else {
                        output.text = "No ratings available."
                    }
                }

                backBtn.setOnClickListener {
                    finish()
                }
            }

    companion object
}

