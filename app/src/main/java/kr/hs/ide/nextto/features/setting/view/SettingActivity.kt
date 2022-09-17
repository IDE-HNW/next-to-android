package kr.hs.ide.nextto.features.setting.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.features.lock.service.LockScreenService

class SettingActivity : AppCompatActivity() {

    private val btnServiceStart: Button by lazy {
        findViewById(R.id.btn_service_start)
    }

    private val btnServiceEnd: Button by lazy {
        findViewById(R.id.btn_service_end)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        btnServiceStart.setOnClickListener {
            this.startForegroundService(Intent(this, LockScreenService::class.java))
        }

        btnServiceEnd.setOnClickListener {
            this.stopService(Intent(this, LockScreenService::class.java))
        }
    }
}