package com.example.lesson2movies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson2movies.R
import com.example.lesson2movies.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment.newInstance())
            .commit()
    }
}