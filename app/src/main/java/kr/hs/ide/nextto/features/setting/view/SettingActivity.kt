package kr.hs.ide.nextto.features.setting.view

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.features.lock.service.LockScreenService

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        checkPermission()
    }

    private fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                val uri = Uri.fromParts("package", packageName, null)
                val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, uri)
                startActivityForResult(intent, 0)
            } else {
                val intent = Intent(applicationContext, LockScreenService::class.java)
                startForegroundService(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "권한을 수락해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(applicationContext, LockScreenService::class.java)
                startForegroundService(intent)
            }
        }
    }
}