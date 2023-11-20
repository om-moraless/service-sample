package com.omoraless.servicesample

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyService: Service() {
    //declaring MediaPlayer Object
    private lateinit var player: MediaPlayer

    //the service execution will start calling this method
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //creating a media player which will play the default audio ringtone in android device
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        //providing the boolean value as true to play the audio on loop
        player.isLooping = true
        //starting the process
        player.start()
        //return the program status
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        //stopping the process
        player.stop()
    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}