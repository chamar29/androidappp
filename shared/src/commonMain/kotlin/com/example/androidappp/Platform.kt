package com.example.androidappp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform