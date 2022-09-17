package kr.hs.ide.nextto.features.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.ActivityMainBinding
import kr.hs.ide.nextto.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    val binding by lazy { ActivitySignInBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.goSignUp.setOnClickListener { startActivity(Intent(this, SignUpActivity::class.java)) }
        binding.login.setOnClickListener {
            val id = binding.signInId.text.toString()
            val pw = binding.signInPw.text.toString()

            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}