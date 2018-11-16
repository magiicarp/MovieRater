package com.example.angelica.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*
import org.intellij.lang.annotations.Language
import java.io.Serializable
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkSuitable.setOnClickListener({
            if (checkSuitable.isChecked == true){
                checkViolence.setVisibility(View.VISIBLE)
                checkLanguage.setVisibility(View.VISIBLE)
            }
            else{
                checkViolence.setVisibility(View.INVISIBLE)
                checkLanguage.setVisibility(View.INVISIBLE)
            }
        })

    }

    fun btnValidate(v:View){
        if (etTitle.text.toString() == "" || etDescription.text.toString() == "" || releaseDate.text.toString() == ""){
            if (etTitle.text.toString() == "") {
                etTitle.setError("Field Empty")
            }
            if (etDescription.text.toString() == "") {
                etDescription.setError("Field Empty")
            }
            if (releaseDate.text.toString() == "") {
                releaseDate.setError("Field Empty")
            }
            }
        else {
            var languageCheck = ""
            var violenceCheck = ""
            var suitableCheck = "true"
            var suitableFor = "Yes"
            val radio: RadioButton = findViewById(radioLanguage.checkedRadioButtonId)
            if (checkSuitable.isChecked){
                suitableCheck ="false"
                suitableFor = "No"
                if(checkViolence.isChecked){
                    violenceCheck = "true"
                }
                if (checkLanguage.isChecked){
                    languageCheck = "true"
                }
            }
            var duration = Toast.LENGTH_LONG
            var viewToastText = "Title = " + etTitle.text.toString() + "\n" +
                                "Overview = " + etDescription.text.toString() + "\n" +
                                "Release Date = " + releaseDate.text.toString() + "\n" +
                                "Language = " + radio.text.toString() + "\n" +
                                "Suitable for all ages = " + suitableCheck + "\n" +
                                "Reason: " + "\n" + "Language: " + languageCheck + "\n" +
                                "Violence: " + violenceCheck

            var toast = Toast.makeText(applicationContext, viewToastText, duration)
            toast.show()

            val movie = MovieEntity(
                etTitle.text.toString(),
                etDescription.text.toString(),
                radio.text.toString(),
                releaseDate.text.toString(),
                suitableFor
            )
            val intent = Intent(this, DetailsMovie::class.java)
            intent.putExtra("extra_movie", movie as Serializable)
            startActivity(intent)

        }


    }



}

