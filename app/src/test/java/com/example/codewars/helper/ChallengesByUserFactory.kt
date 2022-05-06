package com.example.codewars.helper

import com.example.codewars.data.model.Challenges
import com.example.codewars.domain.uimodel.ChallengesUi

object ChallengesByUserFactory {

    val characterList
        get() = listOf(
            challengeItem,
            challengeItem,
            challengeItem,
            challengeItem,
            challengeItem
        )

    val challengeItem
        get() = Challenges(
            "id",
            "name",
            "slug",
            arrayListOf(),
            "completedAt"
        )

    val characterListUI
        get() = listOf(
            challengeItemUI,
            challengeItemUI,
            challengeItemUI,
            challengeItemUI,
            challengeItemUI
        )

    val challengeItemUI
        get() = ChallengesUi(
            "id",
            "name",
            "slug",
            "completedLanguages",
            "completedAt"
        )
}
