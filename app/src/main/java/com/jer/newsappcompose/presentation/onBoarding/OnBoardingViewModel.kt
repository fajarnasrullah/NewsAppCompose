package com.jer.newsappcompose.presentation.onBoarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jer.newsappcompose.domain.usecase.AppEntryUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val entryUseCases: AppEntryUsecases
) : ViewModel() {


    fun onEvent(event: OnBoardingEvent) {
        when(event) {
            is OnBoardingEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }
    }


    private fun saveAppEntry() {
        viewModelScope.launch {
            entryUseCases.saveAppEntry()
        }
    }

}