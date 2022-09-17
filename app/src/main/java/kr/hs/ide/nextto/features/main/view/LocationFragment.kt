package kr.hs.ide.nextto.features.main.view

import android.content.Context
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.location.LocationManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.getSystemService
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.FragmentLocationBinding
import java.util.*
import kotlin.math.sign

class LocationFragment : Fragment() {

    var signUpActivity : SignUpActivity? = null

    private var locationManager : LocationManager? = null
    private var mResult : List<Address>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLocationBinding.inflate(inflater, container, false)
        binding.goLogin.setOnClickListener {
            var location : String? = null
            location = if ( binding.location.visibility != View.GONE){ binding.location.text.toString() }
            else { mResult!![0].getAddressLine(0).toString().substring(11) }
            val deeplocation = binding.deepLocation.text.toString()

            signUpActivity?.goLogin()
        }

        binding.currentLocate.setOnClickListener {
            locationManager = signUpActivity?.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
            val userLocation = signUpActivity?.getLatitudeLongitude(locationManager!!)
            if (userLocation != null) {
                val latitude = userLocation.latitude
                val longitude = userLocation.longitude

                val mGeocoder = Geocoder(context, Locale.KOREA)


                mResult = mGeocoder.getFromLocation(latitude, longitude,1)
                if (mResult != null) {
                    binding.location.visibility = View.GONE
                    Toast.makeText(signUpActivity?.applicationContext, mResult!![0].getAddressLine(0).toString(), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(signUpActivity?.applicationContext, "다시 한번 눌러주세요", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is SignUpActivity) signUpActivity = context
    }
}