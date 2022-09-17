package kr.hs.ide.nextto.features.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.FragmentMainBinding
import kr.hs.ide.nextto.databinding.FragmentProfileBinding
import kr.hs.ide.nextto.features.main.adapter.BenefitAdapter
import kr.hs.ide.nextto.features.main.vm.MainViewModel
import kr.hs.ide.nextto.features.main.vm.ProfileViewModel
import kr.hs.ide.nextto.network.model.BenefitInfo

class ProfileFragment : Fragment() {
    private lateinit var binding : FragmentProfileBinding
    private val viewModel : ProfileViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
        R.layout.fragment_profile,
            container,
            false
        )
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}