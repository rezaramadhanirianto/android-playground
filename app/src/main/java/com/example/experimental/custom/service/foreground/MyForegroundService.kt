package com.example.experimental.custom.service.foreground

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.experimental.R
import com.example.experimental.custom.pendingIntent.SelfNotificationUtils
import com.example.experimental.custom.service.ServiceActivity

class MyForegroundService: Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val input = intent?.getStringExtra(input)
        val notificationIntent = Intent(this, ServiceActivity::class.java)
        val notification = SelfNotificationUtils.provideNotif(this, "Asadf", input ?: "", R.drawable.ic_launcher_foreground, intent = notificationIntent)
        startForeground(1, notification)

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    companion object{
        const val input = "input"
    }
}