package com.example.languagelearner

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val words = listOf(
        Pair("Apple", "سیب"),
        Pair("Book", "کتاب"),
        Pair("Computer", "کامپیوتر"),
        Pair("Friend", "دوست"),
        Pair("Learning", "یادگیری")
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvWord = findViewById<TextView>(R.id.tvWord)
        val tvMeaning = findViewById<TextView>(R.id.tvMeaning)
        val btnNext = findViewById<Button>(R.id.btnNext)

        // نمایش اولین کلمه
        updateWord(tvWord, tvMeaning)

        btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % words.size
            updateWord(tvWord, tvMeaning)
        }
    }

    private fun updateWord(tvWord: TextView, tvMeaning: TextView) {
        val currentPair = words[currentIndex]
        tvWord.text = currentPair.first
        tvMeaning.text = currentPair.second
    }
}
