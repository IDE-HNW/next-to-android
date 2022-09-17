package kr.hs.ide.nextto.features.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.FragmentMainBinding
import kr.hs.ide.nextto.features.main.vm.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel = MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}