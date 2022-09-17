package kr.hs.ide.nextto.features.main.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    var signUpActivity : SignUpActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater, container, false)


        binding.signUpNext.setOnClickListener {
            val id = binding.signUpId.text.toString()
            val pw = binding.signUpPw.text.toString()
            val age = binding.age.text.toString()
            val emergency = binding.emergencyContact.text.toString()

            signUpActivity?.goLocation()
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is SignUpActivity) signUpActivity = context
    }
}