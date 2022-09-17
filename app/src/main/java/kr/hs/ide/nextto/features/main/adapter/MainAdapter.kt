package kr.hs.ide.nextto.features.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.ItemBenefitBinding
import kr.hs.ide.nextto.features.main.adapter.callback.MainDiffUtilCallBack
import kr.hs.ide.nextto.network.model.BenefitInfo

class MainAdapter : ListAdapter<BenefitInfo,MainAdapter.BenefitViewHolder>(MainDiffUtilCallBack()) {

    inner class BenefitViewHolder(private val binding: ItemBenefitBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BenefitInfo) {
            binding.info = item
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitViewHolder {
        return BenefitViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_benefit,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: BenefitViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }
}