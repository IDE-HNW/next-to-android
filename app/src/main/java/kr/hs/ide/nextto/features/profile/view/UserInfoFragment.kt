package kr.hs.ide.nextto.features.profile.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.FragmentUserInfoBinding
import kr.hs.ide.nextto.features.profile.vm.UserInfoViewModel

class UserInfoFragment : Fragment() {
    private lateinit var binding : FragmentUserInfoBinding
    private val viewModel : UserInfoViewModel by viewModels()

    init {
        Log.d("UserInfoFragment","생성")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
        R.layout.fragment_user_info,
            container,
            false
        )
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}