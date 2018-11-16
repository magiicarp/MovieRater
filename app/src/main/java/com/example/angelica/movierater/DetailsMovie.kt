package com.example.angelica.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.view_movie_details.*
import android.view.View
import android.widget.Toast
import android.widget.Button;
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*
import org.intellij.lang.annotations.Language
import java.io.Serializable
import java.util.*

class DetailsMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_movie_details)
        val movie = intent.extras.get("extra_movie") as MovieEntity

        mTitle.text = movie.Title
        mOverview.text = movie.Overview
        mLanguage.text = movie.Language
        mReleaseDate.text = movie.ReleaseDate
        mSuitable.text = movie.Suitable
    }



}