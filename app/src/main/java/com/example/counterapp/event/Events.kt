package com.example.counterapp.event

sealed class Events{
    data object Addition: Events()
    data object Subtraction: Events()
    data object Reset: Events()
}