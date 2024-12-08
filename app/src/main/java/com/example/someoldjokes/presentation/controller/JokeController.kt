package com.example.someoldjokes.presentation.controller

import com.example.someoldjokes.presentation.model.Joke

import retrofit2.http.GET
import retrofit2.http.Headers

// Interface name can be same or different
interface JokeController {

    @Headers("Accept: application/json")
    @GET("/")
    suspend fun getJoke(): Joke
}