package com.lovendro.farasi_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Finding the id from the layout

//        create variable to store the data

        val recipe=findViewById<Button>(R.id.recipes)

//        calling the setOnclick listener
        recipe.setOnClickListener {
//            set your intent
            val recipeIntent= Intent(applicationContext, HealthyRecipes::class.java)
            startActivity(recipeIntent)


        }

//        Nutrition intent
        val nutrition=findViewById<Button>(R.id.nutrition)

        nutrition.setOnClickListener {
            val nutritionIntent= Intent(applicationContext, NutritionAdvice::class.java)
            startActivity(nutritionIntent)
        }
//meditation intent
        val meditation=findViewById<Button>(R.id.meditation)

        meditation.setOnClickListener {
            val meditationIntent= Intent(applicationContext, Meditation::class.java)
            startActivity(meditationIntent)
        }

//        Hydration alert intent

        val hydration=findViewById<Button>(R.id.hydration)
        hydration.setOnClickListener {
            val hydrationIntent= Intent(applicationContext, HydrationAlert::class.java)
            startActivity(hydrationIntent)
        }

//        start exercise intent
        val start=findViewById<Button>(R.id.exercise)
        start.setOnClickListener {
            val startIntent= Intent(applicationContext, StartExercise::class.java)
            startActivity(startIntent)
        }

//        Daily motivation intent
        val motivation=findViewById<Button>(R.id.Motivation)
        motivation.setOnClickListener {
            val motivationIntent= Intent(applicationContext, DailyMotivation::class.java)
            startActivity(motivationIntent)
        }

//        weekly goals intent
        val goals =findViewById<Button>(R.id.goals)
        goals.setOnClickListener {
            val goalsIntent= Intent(applicationContext, WeeklyGoals::class.java)
            startActivity(goalsIntent)
        }

        val progress=findViewById<Button>(R.id.progress)
        progress.setOnClickListener {
            val progressIntent= Intent(applicationContext, CheckProgress::class.java)
            startActivity(progressIntent)
        }


    }


}