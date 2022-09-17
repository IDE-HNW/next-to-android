package kr.hs.ide.nextto.features.lock.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kr.hs.ide.nextto.R

object LockBindingAdapter {

    @JvmStatic
    @BindingAdapter("tip_image")
    fun setTipImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .centerCrop()
            .error(R.drawable.dummy)
            .into(view)
    }

}