package com.example.experimental.custom.pendingIntent

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat


object SelfNotificationUtils {
    fun showNotif(
        context: Context,
        title: String,
        description: String,
        iconRes: Int,
        channelId: String = "101",
        channelName: String = "channel_name",
        notificationId: Int = 101,
        importance: Int? = null, // value of NotificationManager.IMPORTANCE_HIGH
        intent: Intent? = null
    ){

        val notificationManagerCompat =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(iconRes)
            .setContentTitle(title)
            .setContentText(description)
            .setColor(ContextCompat.getColor(context, android.R.color.transparent))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val importanceLevel = importance ?: NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(
                channelId,
                channelName,
                importanceLevel
            )
            builder.setChannelId(channelId)

            notificationManagerCompat.createNotificationChannel(channel)
        }

        intent?.let {
            val pendingIntent = PendingIntent.getActivity(context, 0, intent,0)
            builder.setContentIntent(pendingIntent)
        }

        val notification = builder.build()
        notificationManagerCompat.notify(notificationId, notification)
    }

    fun provideNotif(
        context: Context,
        title: String,
        description: String,
        iconRes: Int,
        channelId: String = "101",
        channelName: String = "channel_name",
        notificationId: Int = 101,
        importance: Int? = null, // value of NotificationManager.IMPORTANCE_HIGH
        intent: Intent? = null
    ): Notification {

        val notificationManagerCompat =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(iconRes)
            .setContentTitle(title)
            .setContentText(description)
            .setColor(ContextCompat.getColor(context, android.R.color.transparent))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val importanceLevel = importance ?: NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(
                channelId,
                channelName,
                importanceLevel
            )
            builder.setChannelId(channelId)

            notificationManagerCompat.createNotificationChannel(channel)
        }

        intent?.let {
            val pendingIntent = PendingIntent.getActivity(context, 0, intent,0)
            builder.setContentIntent(pendingIntent)
        }

        val notification = builder.build()
        return notification
    }

    fun cancelNotif(context: Context, notificationId: Int = 101){
        val nMgr = context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        nMgr.cancel(notificationId)
    }
}