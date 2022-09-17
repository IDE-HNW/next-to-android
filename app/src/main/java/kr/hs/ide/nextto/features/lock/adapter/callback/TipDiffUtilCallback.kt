package kr.hs.ide.nextto.features.lock.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hs.ide.nextto.network.model.tip.Tip

object TipDiffUtilCallback: DiffUtil.ItemCallback<Tip>() {
    override fun areItemsTheSame(oldItem: Tip, newItem: Tip): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Tip, newItem: Tip): Boolean {
        return oldItem.title == newItem.title
    }

}