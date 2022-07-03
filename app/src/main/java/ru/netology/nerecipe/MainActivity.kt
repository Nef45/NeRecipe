package ru.netology.nerecipe

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nerecipe.dto.Categories
import ru.netology.nerecipe.ui.FiltersFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref =
            getSharedPreferences(FiltersFragment.SHARED_PREFS_KEY, Context.MODE_PRIVATE)
        if (sharedPref != null) {
            with(sharedPref.edit()) {
                for (i in 0 until Categories.values().size) {
                    putBoolean(i.toString(), false)
                }
                apply()
            }
        }

    }
}