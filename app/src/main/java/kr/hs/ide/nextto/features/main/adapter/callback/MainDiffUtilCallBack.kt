package kr.hs.ide.nextto.features.main.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hs.ide.nextto.network.model.BenefitInfo

class MainDiffUtilCallBack : DiffUtil.ItemCallback<BenefitInfo>() {
    override fun areItemsTheSame(oldItem: BenefitInfo, newItem: BenefitInfo): Boolean {
        return oldItem == newItem
    }
    override fun areContentsTheSame(oldItem: BenefitInfo, newItem: BenefitInfo): Boolean {
        return oldItem == newItem
    }
}