package kr.hs.ide.nextto.features.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.FragmentMainBinding
import kr.hs.ide.nextto.features.main.vm.MainViewModel

class MainFragment : Fragment() {
    private lateinit var binding : FragmentMainBinding
    private val viewModel : MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
        R.layout.fragment_main,
            container,
            false
        )
        binding.rvMainList.adapter =
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}