package kr.hs.ide.nextto.features.main.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.FragmentDepressionBinding


class DepressionFragment : Fragment() {

    init {
        Log.d("DepressionFragment","생성")
    }

    var score = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDepressionBinding.inflate(inflater, container, false)
        binding.c1No.setOnClickListener { score++ }
        binding.c2No.setOnClickListener { score++ }
        binding.c3No.setOnClickListener { score++ }
        binding.c4No.setOnClickListener { score++ }
        binding.c5No.setOnClickListener { score++ }
        binding.c6No.setOnClickListener { score++ }
        binding.c7No.setOnClickListener { score++ }
        binding.c8No.setOnClickListener { score++ }
        binding.c9No.setOnClickListener { score++ }
        binding.c10No.setOnClickListener { score++ }
        binding.c11No.setOnClickListener { score++ }
        binding.c12No.setOnClickListener { score++ }
        binding.c13No.setOnClickListener { score++ }
        binding.c14No.setOnClickListener { score++ }
        binding.c15No.setOnClickListener { score++ }
        binding.c1Yes.setOnClickListener { score-- }
        binding.c2Yes.setOnClickListener { score-- }
        binding.c3Yes.setOnClickListener { score-- }
        binding.c4Yes.setOnClickListener { score-- }
        binding.c5Yes.setOnClickListener { score-- }
        binding.c6Yes.setOnClickListener { score-- }
        binding.c7Yes.setOnClickListener { score-- }
        binding.c8Yes.setOnClickListener { score-- }
        binding.c9Yes.setOnClickListener { score-- }
        binding.c10Yes.setOnClickListener { score-- }
        binding.c11Yes.setOnClickListener { score-- }
        binding.c12Yes.setOnClickListener { score-- }
        binding.c13Yes.setOnClickListener { score-- }
        binding.c14Yes.setOnClickListener { score-- }
        binding.c15Yes.setOnClickListener { score-- }
        binding.submit.setOnClickListener {
            if (score >= 10) { Toast.makeText(context!!, "우울증이 의심됩니다! 전문가와 상담을 해보시거나  노인복지관, 경로당 및 노인교실에 가서 여가를 즐겨보는 것은 어떤가요?", Toast.LENGTH_SHORT).show() }
            else { Toast.makeText(context!!, "정상 이십니다!", Toast.LENGTH_SHORT).show() }

            binding.c1No.isChecked = false
            binding.c2No.isChecked = false
            binding.c3No.isChecked = false
            binding.c4No.isChecked = false
            binding.c5No.isChecked = false
            binding.c6No.isChecked = false
            binding.c7No.isChecked = false
            binding.c8No.isChecked = false
            binding.c9No.isChecked = false
            binding.c10No.isChecked = false
            binding.c11No.isChecked = false
            binding.c12No.isChecked = false
            binding.c13No.isChecked = false
            binding.c14No.isChecked = false
            binding.c15No.isChecked = false
            binding.c1Yes.isChecked = false
            binding.c2Yes.isChecked = false
            binding.c3Yes.isChecked = false
            binding.c4Yes.isChecked = false
            binding.c5Yes.isChecked = false
            binding.c6Yes.isChecked = false
            binding.c7Yes.isChecked = false
            binding.c8Yes.isChecked = false
            binding.c9Yes.isChecked = false
            binding.c10Yes.isChecked = false
            binding.c11Yes.isChecked = false
            binding.c12Yes.isChecked = false
            binding.c13Yes.isChecked = false
            binding.c14Yes.isChecked = false
            binding.c15Yes.isChecked = false
        }
        return binding.root
    }

}