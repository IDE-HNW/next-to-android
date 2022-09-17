package kr.hs.ide.nextto.features.main.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.FragmentMainBinding
import kr.hs.ide.nextto.features.main.adapter.BenefitAdapter
import kr.hs.ide.nextto.features.main.vm.HomeViewModel
import kr.hs.ide.nextto.network.model.BenefitInfo

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentMainBinding
    private val viewModel : HomeViewModel by viewModels()

    init {
        Log.d("MainFragment","생성")
    }
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}