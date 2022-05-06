package com.example.codewars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.codewars.databinding.FragmentChallengeDetailsBinding
import com.example.codewars.domain.viewmodel.ChallengeDetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class ChallengeDetailsFragment : Fragment() {
    private val challengeDetailsViewModel: ChallengeDetailsViewModel by viewModel()
    private lateinit var binding: FragmentChallengeDetailsBinding
    private val args by navArgs<ChallengeDetailsFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChallengeDetailsBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = challengeDetailsViewModel
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        challengeDetailsViewModel.getChallengeDetails(args.idChallenge)
    }
}