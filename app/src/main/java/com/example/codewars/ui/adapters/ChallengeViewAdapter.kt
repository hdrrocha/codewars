package com.example.codewars.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.codewars.R
import com.example.codewars.databinding.ChallengeRowItemBinding
import com.example.codewars.domain.uimodel.ChallengesUi

class ChallengeViewAdapter : PagingDataAdapter<ChallengesUi, ChallengeViewAdapter.ViewHolder>(
    CharacterInfoUiItemComparator
) {

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<ChallengeRowItemBinding>(
            inflater, viewType, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun getItemViewType(position: Int) = R.layout.challenge_row_item

    inner class ViewHolder(
        private val binding: ChallengeRowItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        var dominantColor: Int = 0

        fun bind(item: ChallengesUi) {
            binding.item = item
            binding.invalidateAll()

            onItemClickListener?.let { listener ->
                itemView.setOnClickListener { listener.onItemClick(item.id) }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(id: String?)
    }

    object CharacterInfoUiItemComparator : DiffUtil.ItemCallback<ChallengesUi>() {
        override fun areItemsTheSame(
            oldItem: ChallengesUi,
            newItem: ChallengesUi
        ) = oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: ChallengesUi,
            newItem: ChallengesUi
        ) = oldItem == newItem
    }
}
