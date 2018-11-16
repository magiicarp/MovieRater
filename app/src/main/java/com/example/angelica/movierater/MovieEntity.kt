package com.example.angelica.movierater

import java.io.Serializable


class MovieEntity(Title: String, Overview: String, Language: String, ReleaseDate: String, Suitable: String ):Serializable {

    val Title = Title
    val Overview = Overview
    val Language = Language
    val ReleaseDate = ReleaseDate
    val Suitable = Suitable

}