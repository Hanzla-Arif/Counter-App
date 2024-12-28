package com.example.counterapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.counterapp.event.Events
import com.example.counterapp.dataclass.Numbers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var currentValues = MutableStateFlow(Numbers(0))
    val currentValue = currentValues.asStateFlow()
   private var counter = 0

    fun events(event: Events) {

        when (event) {
            Events.Addition -> {
                if (currentValues.value.number<100){
                   counter++
                  currentValues.value = Numbers(counter)
                 sendValue(currentValues.value.number)

            }
        }

        Events.Subtraction -> {
            if (currentValues.value.number > 0) {
                counter--
                currentValues.value = Numbers(counter)
                sendValue(currentValues.value.number)
            }
        }

        Events.Reset -> {
            counter = 0
            currentValues.value = Numbers(counter)
            sendValue(currentValues.value.number)
        }

    }

}




private fun sendValue(value: Int) {
    viewModelScope.launch {
        currentValues.emit(Numbers(value))
    }

}

}
