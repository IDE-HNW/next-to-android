package kr.hs.ide.nextto.features.main.view

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.rabbitmq.client.AMQP
import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope
import kotlinx.coroutines.*
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.databinding.ActivityMainBinding
import okio.Utf8
import java.io.IOException
import kotlin.concurrent.thread
import kotlin.jvm.Throws

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val channelId = "testChannel"

    private var notificationManager: NotificationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setContentView(binding.root)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_Container_View) as NavHostFragment

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val navController = navHostFragment.navController

        binding.bottomNav
            .setupWithNavController(navController)
        checkPermission()

        createNotificationChannel(channelId, "test", "test채널")
        thread {
            data()
        }
    }

    fun data() {
        try {
            val QUEUE_NAME = "next-to"

            val connect = ConnectionFactory()
            connect.host = "10.80.162.98"
            connect.username = "next-to"
            connect.password = "saveThem"
            connect.port = 5672

            val connection = connect.newConnection()
            val channel = connection.createChannel()

            channel.queueDeclare(QUEUE_NAME, false, false, false, null)
            val consumer = object : DefaultConsumer(channel) {
                @Throws(IOException::class)
                override fun handleDelivery(
                    consumerTag: String?, envelope: Envelope?,
                    properties: AMQP.BasicProperties?, body: ByteArray?
                ) {
                    val message = String(body!!, Charsets.UTF_8)
                    notification(message)
                    Log.e("mess", message)
                }
            }


            channel.basicConsume(QUEUE_NAME, true, consumer)

        } catch (e : Exception) {
            Log.e("error", e.message.toString())
            e.printStackTrace();
        }
    }


    private fun notification(message: String) {
        val id = 45

        val tabResult = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pending = PendingIntent.getActivity(this, 0, tabResult, PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("한번만 클릭해 주세요!")
            .setSmallIcon(R.drawable.ic_profile)
            .setContentText(message)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pending)
            .build()

        notificationManager?.notify(id, notification)
    }

    private fun createNotificationChannel(id: String, name: String, channelDescription: String) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //중요도
            val importance = NotificationManager.IMPORTANCE_HIGH
            //채널 생성
            val channel = NotificationChannel(id, name, importance).apply {
                description = channelDescription
            }
            notificationManager?.createNotificationChannel(channel)
        } else {

        }

    }

    private fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                val uri = Uri.fromParts("package", packageName, null)
                val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, uri)
                startActivityForResult(intent, 0)
            } else {
                val intent = Intent(applicationContext, LockScreenService::class.java)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(intent)
                }
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
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(intent)
                }
            }
        }
    }
}

