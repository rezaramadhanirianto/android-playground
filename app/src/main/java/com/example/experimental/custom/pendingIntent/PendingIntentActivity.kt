package com.example.experimental.custom.pendingIntent

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.experimental.R
import com.example.experimental.databinding.ActivityPendingIntentBinding


class PendingIntentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPendingIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPendingIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
            SelfNotificationUtils.showNotif(this, "Click To Webview", "Description", R.drawable.ic_launcher_foreground, intent = intent)
        }

        binding.button2.setOnClickListener{
            SelfNotificationUtils.cancelNotif(this)
        }
    }
}