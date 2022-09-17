package kr.hs.ide.nextto.features.main.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.FragmentLocationBinding

class LocationFragment : Fragment() {

    var signUpActivity : SignUpActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLocationBinding.inflate(inflater, container, false)
        binding.goLogin.setOnClickListener { signUpActivity?.goLogin() }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is SignUpActivity) signUpActivity = context
    }
}