package kr.hs.ide.nextto.features.main.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
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

    fun goLocation(profileFragment: ProfileFragment) {
        val locationFragment = LocationFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.remove(profileFragment)
        transaction.add(R.id.sign_up_frame, locationFragment)
        transaction.commit()
    }

    fun goLogin() {
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }

    fun getLatitudeLongitude(locationManager: LocationManager) : Location{
        var currentLatLng : Location? = null
        if (ActivityCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), 2)
        } else {
            val locationPvd = LocationManager.GPS_PROVIDER
            currentLatLng = locationManager.getLastKnownLocation(locationPvd)
        }
        return currentLatLng!!
    }
}