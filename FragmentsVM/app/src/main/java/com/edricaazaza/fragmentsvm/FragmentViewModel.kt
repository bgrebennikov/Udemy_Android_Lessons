package com.edricaazaza.fragmentsvm

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel : ViewModel() {

    private lateinit var timer: CountDownTimer

    private var _timerText = MutableLiveData<String>()
    val timerText : LiveData<String> get() = _timerText

    init {
        startTimer()
    }


    fun resetTimer(){
        timer.cancel()
        startTimer()
    }

    private fun startTimer(){
        timer = object : CountDownTimer(5 * 1000, 1000){
            override fun onTick(p0: Long) {
                _timerText.postValue(((p0/1000)+1).toString())
            }

            override fun onFinish() {
                _timerText.postValue("Time Over!")
            }

        }

        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }

}