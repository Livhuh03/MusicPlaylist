package com.example.musicplaylist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity


private val DetailedViewActivity.Companion.comments: Any
    get() {
        TODO("Not yet implemented")
    }

abstract class MainActivity : ComponentActivity() {


    private val songs: java.util.ArrayList<String>? = null
    private val artists: java.util.ArrayList<String>? = null
    private val comment: java.util.ArrayList<String>? = null
    private val ratings: ArrayList<Int>? = null

    // Parallel arrays private val songs = ArraysList<String>() private val artists = ArrayList<String>()private val ratings = ArrayList<Int>() private comments = ArrayList<String>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val songInput = findViewById<EditText>(R.id.etSong)
        val artistInput = findViewById<EditText>(R.id.etArtist)
        val ratingInput = findViewById<EditText>(R.id.etRating)
        val commentInput = findViewById<EditText>(R.id.etComment)

        val addBtn = findViewById<Button>(R.id.btnAdd)
        val viewDetailsBtn = findViewById<Button>(R.id.btnDetails)
        val exitBtn = findViewById<Button>(R.id.btnExit)

        addBtn.setOnClickListener {
            try {
                val song = songInput.text.toString()
                val artist = artistInput.text.toString()
                val rating = ratingInput.text.toString().toInt()
                val comment = commentInput.text.toString()

                if (song.isBlank() || artist.isBlank() || rating !in
                    1..5 || comment.isBlank()
                ) {
                    Toast.makeText(this, "Enter valid details.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (songs?.size!! >= 4) {
                    Toast.makeText(this, "Maximum of 4 songs allowed.", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }


                songs.add(song)
                artist.add(artist)
                ratings!!.add(rating)
                DetailedViewActivity.comments.add(comment)
                Toast.makeText(this, "Song Added!", Toast.LENGTH_SHORT).show()


                songInput.text.clear()
                artistInput.text.clear()
                ratingInput.text.clear()
                commentInput.text.clear()

            } catch (e: Exception) {
                Toast.makeText(
                    this, "Error:${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        viewDetailsBtn.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java).apply {
                putStringArrayListExtra("songs", songs)
                putStringArrayListExtra("artists", artists)
                putIntegerArrayListExtra("ratings", ratings)
                putStringArrayListExtra("comments", comment)
            }
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            finish()
        }
    }
}

private fun Any.add(comment: String) {
    TODO("Not yet implemented")
}

private fun String.add(artist: String) {
    TODO("Not yet implemented")
}

