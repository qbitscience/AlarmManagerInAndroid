package com.qbitscience.alarmmanagerinandroid

import android.content.BroadcastReceiver
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MyBroadcastReceiver : BroadcastReceiver() {
    lateinit var mp: MediaPlayer
    override fun onReceive(context: Context, intent: Intent?) {
        mp = MediaPlayer.create(context, R.raw.song)
        try {
            Thread.sleep(5000)
            mp!!.start()

        }
        catch (e:Exception){

        }

        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show()
    }
}