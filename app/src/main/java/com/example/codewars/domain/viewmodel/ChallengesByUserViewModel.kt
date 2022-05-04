package com.example.codewars.domain.viewmodel

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.codewars.domain.uimodel.ChallengesUi
import com.example.codewars.domain.usercase.abs.ChallengesByUserUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ChallengesByUserViewModel(
    private val useUseCase: ChallengesByUserUseCase
) : ViewModel() {
    private val mutableData = MutableLiveData<PagingData<ChallengesUi>>()

    val data get() = mutableData as LiveData<PagingData<ChallengesUi>>

    val error = MutableLiveData<Boolean>()

    val loading = Transformations.map(mutableData) {
        it != null
    }

    fun loadData() = viewModelScope.launch {
        try {
            if (mutableData.value != null) return@launch
            useUseCase.fetchChallengesbyUser().cachedIn(viewModelScope).collect {
                mutableData.value = it

            }
        } catch (e: Exception) {
            error.value = true
        }
    }
}