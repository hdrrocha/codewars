package com.example.codewars.domain.viewmodel


import androidx.lifecycle.*
import com.example.codewars.domain.uimodel.ChallengesDetailsUi
import com.example.codewars.domain.usercase.abs.ChallengeDetailsUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class ChallengeDetailsViewModel(
    private val useCase: ChallengeDetailsUseCase
) : ViewModel() {
    private var mutableData = MutableLiveData<ChallengesDetailsUi>()

    val data get() = mutableData as LiveData<ChallengesDetailsUi>

    val error = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    val name = Transformations.map(mutableData) {
       it.name
    }

    val id = Transformations.map(mutableData) {
        it.id
    }

    val slug = Transformations.map(mutableData) {
        it.slug
    }
    val category = Transformations.map(mutableData) {
        it.category
    }
    val publishedAt = Transformations.map(mutableData) {
        it.publishedAt
    }
    val approveDat = Transformations.map(mutableData) {
        it.approveDat
    }
    val languages = Transformations.map(mutableData) {
        it.languages
    }
    val url = Transformations.map(mutableData) {
        it.url
    }
    val rankId = Transformations.map(mutableData) {
        it.rank?.id
    }
    val rankName: LiveData<String?> = Transformations.map(mutableData) {
        it.rank?.name
    }
    val rankColor = Transformations.map(mutableData) {
        it.rank?.color
    }
    val createdAt = Transformations.map(mutableData) {
        it.createdAt
    }
    val createdUsername = Transformations.map(mutableData) {
        it.createdBy?.username
    }
    val createdUrl = Transformations.map(mutableData) {
        it.createdBy?.url
    }
    val approvedByUsername = Transformations.map(mutableData) {
        it.createdBy?.username
    }
    val approvedByUrl = Transformations.map(mutableData) {
        it.createdBy?.url
    }
    val description = Transformations.map(mutableData) {
        it.description
    }
    val totalAttempts = Transformations.map(mutableData) {
        it.totalAttempts
    }
    val totalCompleted = Transformations.map(mutableData) {
        it.totalCompleted
    }
    val totalStars = Transformations.map(mutableData) {
        it.totalStars
    }
    val voteScore = Transformations.map(mutableData) {
        it.voteScore
    }
    val tagsOfChallenge = Transformations.map(mutableData) {
        it.tags
    }
    val contributorsWanted = Transformations.map(mutableData) {
        it.contributorsWanted
    }
    val unresolvedIssues = Transformations.map(mutableData) {
        it.unresolved?.issues
    }

    val unresolvedSuggestions = Transformations.map(mutableData) {
        it.unresolved?.suggestions
    }

    fun getChallengeDetails(id: String) = viewModelScope.launch {
        try {
            loading.value = true
            if (mutableData.value != null) return@launch
            mutableData.value = useCase.getChallengeDetails(id)
        } catch (e: Exception) {
            error.value = true
            loading.value = false
        } finally {
            loading.value = false
        }
    }
}