package com.bgrebennikov.github.foregroundserviceexample

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.*

class ForegroundService : Service() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private val notificationManager by lazy { getSystemService(NOTIFICATION_SERVICE) as NotificationManager }

    @RequiresApi(Build.VERSION_CODES.O)
    private val notificationChannel = NotificationChannel(CH_ID, CH_NAME, NotificationManager.IMPORTANCE_DEFAULT)

    override fun onCreate() {
        super.onCreate()

        startForeground(NOTIFICATION_ID, createNotification())
    }

    private fun createNotification() : Notification{

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(notificationChannel)
        }

        return NotificationCompat.Builder(this, CH_ID)
            .setContentTitle("Service is worked")
            .setContentText("work on background")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()


    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        coroutineScope.launch {
            for (i in 0 until 100){
                Log.i(TAG, "Step: $i")
                delay(1000L)
            }
        }

        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }

    companion object{

        private const val TAG = "MESSAGE"

        private const val CH_ID = "ch_id"
        private const val CH_NAME = "ch_name"
        private const val NOTIFICATION_ID = 1

        fun newInstance(context: Context): Intent{
            return Intent(context, ForegroundService::class.java)
        }
    }
}