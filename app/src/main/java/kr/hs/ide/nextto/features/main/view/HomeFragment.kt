package kr.hs.ide.nextto.features.main.view

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kr.hs.ide.nextto.BR
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.FragmentHomeBinding
import kr.hs.ide.nextto.features.main.adapter.BenefitAdapter
import kr.hs.ide.nextto.features.main.vm.HomeViewModel
import kr.hs.ide.nextto.network.model.BenefitInfo
import java.lang.reflect.ParameterizedType
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private val viewModel = HomeViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()

        val list = listOf(
            BenefitInfo("제목1","내용1","사진"),
            BenefitInfo("제목2","내용2","사진"),
            BenefitInfo("제목3","내용3","사진")
        )

        val adapter = BenefitAdapter()

        with(binding.rvMainList){
            this.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
            adapter.submitList(list)
        }
    }

    private fun setUp() {
        binding.setVariable(BR.vm, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}