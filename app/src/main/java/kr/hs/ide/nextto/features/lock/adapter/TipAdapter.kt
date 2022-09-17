package kr.hs.ide.nextto.features.lock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.ItemTipBinding
import kr.hs.ide.nextto.features.lock.adapter.callback.TipDiffUtilCallback
import kr.hs.ide.nextto.network.model.tip.Tip

class TipAdapter(private val action: (link: String) -> Unit) : ListAdapter<Tip, TipAdapter.TipViewHolder>(TipDiffUtilCallback) {

    inner class TipViewHolder(private val binding: ItemTipBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tip: Tip) {
            binding.tip = tip
            binding.root.setOnClickListener {
                action.invoke(tip.link)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        return TipViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_tip,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}