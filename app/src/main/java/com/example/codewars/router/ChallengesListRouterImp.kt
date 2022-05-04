package com.example.codewars.router

import androidx.navigation.NavController
import com.example.codewars.router.abs.ChallengesListRouter
import com.example.codewars.ui.fragments.ChallengesListFragmentDirections

class ChallengesListRouterImp(
    private val navController: NavController
) : ChallengesListRouter {

    override fun goToDetails(id: String) {
        val directions =
            ChallengesListFragmentDirections.fragmentCharacterListToFragmentCharacterDetails(id)
        navController.navigate(directions)
    }

    override fun goBack() {
        navController.navigateUp()
    }
}
