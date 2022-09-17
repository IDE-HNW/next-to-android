package kr.hs.ide.nextto.features.lock.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.features.lock.view.LockActivity
import kr.hs.ide.nextto.features.setting.view.SettingActivity

class LockScreenService : Service() {
    private val receiver = object:BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                when (intent.action) {
                    Intent.ACTION_SCREEN_OFF -> {
                        val newIntent = Intent(context, LockActivity::class.java)

                        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

                        startActivity(newIntent)

                    }
                }
            }
        }

    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private val ALARM_ID = "kr.hs.ide.nextto.lockscreen"

    override fun onCreate() {
        super.onCreate()

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channel = NotificationChannel(ALARM_ID, "잠금화면", NotificationManager.IMPORTANCE_DEFAULT)
        nm.createNotificationChannel(channel)

        val pending = PendingIntent.getActivity(this, 0, Intent(this, SettingActivity::class.java), PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        val notification = Notification.Builder(this, ALARM_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("잠금화면 서비스가 동작중이에요")
            .setContentText("오늘 행복한 하루가 되기를 바래요!")
            .setContentIntent(pending)
            .build()

        startForeground(1, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_SCREEN_OFF)

        registerReceiver(receiver, filter)

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}