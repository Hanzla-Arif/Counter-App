package com.example.counterapp

sealed class Events{
    data object Addition:Events()
    data object Subtraction:Events()
    data object Reset:Events()
}