package com.example.codewars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.paging.PagingData
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codewars.databinding.FragmentChallengesListBinding
import com.example.codewars.domain.viewmodel.ChallengesByUserViewModel
import com.example.codewars.router.abs.ChallengesListRouter
import com.example.codewars.ui.adapters.ChallengeItemsLoadStateAdapter
import com.example.codewars.ui.adapters.ChallengeViewAdapter
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ChallengesListFragment : Fragment() {

    private val router: ChallengesListRouter by inject { parametersOf(findNavController()) }

    private val viewModel: ChallengesByUserViewModel by viewModel()

    private lateinit var binding: FragmentChallengesListBinding

    private val characterViewAdapter = ChallengeViewAdapter()
    private val headerAdapter = ChallengeItemsLoadStateAdapter { characterViewAdapter.retry() }
    private val footerAdapter = ChallengeItemsLoadStateAdapter { characterViewAdapter.retry() }
    private var listener: ChallengeViewAdapter.OnItemClickListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChallengesListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupObservers()
        viewModel.loadData()

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun setupRecycler() {
        listener = object : ChallengeViewAdapter.OnItemClickListener {
            override fun onItemClick(id: String?) = handleOnClickEvent(id)
        }
        characterViewAdapter.onItemClickListener = listener

        characterViewAdapter.addLoadStateListener { loadStates ->
            headerAdapter.loadState = loadStates.refresh
            footerAdapter.loadState = loadStates.append
        }

        binding.rvChallengeList.run {
            layoutManager = LinearLayoutManager(context)
            isNestedScrollingEnabled = false
            itemAnimator = null

            adapter = ConcatAdapter(headerAdapter, characterViewAdapter, footerAdapter)
            setHasFixedSize(true)
        }

        characterViewAdapter.submitData(lifecycle, PagingData.empty())
    }

    private fun setupObservers() {
        viewModel.data.observe(viewLifecycleOwner) {
            characterViewAdapter.submitData(lifecycle, it)
        }
    }

    private fun handleOnClickEvent(id: String?) {
        val args by navArgs<ChallengesListFragmentArgs>()
        if (args.isComparing) {
            router.goBack()
        } else {
            if (id != null) {
                router.goToDetails(id)
            }
        }
    }
}