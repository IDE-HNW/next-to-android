package kr.hs.ide.nextto.features.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    val binding by lazy { ActivitySignUpBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setView()
    }

    private fun setView() {
        val profileFragment = ProfileFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.sign_up_frame, profileFragment)
        transaction.commit()
    }

    fun goLocation() {
        val locationFragment = LocationFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.sign_up_frame, locationFragment)
        transaction.commit()
    }

    fun goLogin() {
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }
}