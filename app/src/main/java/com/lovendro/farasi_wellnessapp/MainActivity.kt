package com.lovendro.farasi_wellnessapp

import android.content.Intent
//import android.media.tv.AdRequest
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError


import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class MainActivity : AppCompatActivity() {

//    declare a variable to store our interstitial ad
    private var mInterstitialAd: InterstitialAd?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        implementation of the banner add
//        starts the google admob sdk
//        prepares your app to load ads
//        must be called before showing ads
        MobileAds.initialize(this)

//        get the ad view from layout
//        connects your kotlin code to the adview xml
        val adView=findViewById<AdView>(R.id.adView)

//        creates request asking admob for an ad
        val adRequest= AdRequest.Builder().build()

//        load the ad
//        send request admob
//        admob returns an ad
//        the add is displayed in your app
        adView.loadAd(adRequest)

        loadInterstitialAd()


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

            showInterstitialAd()


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
//a function to load our ad from the server
fun loadInterstitialAd() {
    val adRequest = AdRequest.Builder().build()

    InterstitialAd.load(
        this,
        "ca-app-pub-3940256099942544/1033173712", // Test ID
        adRequest,
        object : InterstitialAdLoadCallback() {

            override fun onAdLoaded(ad: InterstitialAd) {
                mInterstitialAd = ad
            }

            override fun onAdFailedToLoad(error: LoadAdError) {
                mInterstitialAd = null
            }
        }
    )
}
    //Show Interstitial ad
    fun showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        }
    }

    }