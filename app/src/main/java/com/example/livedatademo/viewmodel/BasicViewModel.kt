package com.example.livedatademo.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BasicViewModel : ViewModel() {

    private lateinit var timer: CountDownTimer
    private val _seconds = MutableLiveData<Int>()
    private val finished = MutableLiveData<Boolean>()

    var _finished : LiveData<Boolean> = finished

    fun seconds() : LiveData<Int>
    {
         return _seconds
    }

    fun startTimer()
    {
         timer = object : CountDownTimer(10000,1000)
         {
             override fun onFinish() {
                 finished.value = true
             }

             override fun onTick(millisUntilFinished: Long) {
                 val timeLeft = millisUntilFinished/1000
                 _seconds.value = timeLeft.toInt()
             }

         }.start()
    }

    fun stopTimer()
    {
         timer.cancel()
    }
}