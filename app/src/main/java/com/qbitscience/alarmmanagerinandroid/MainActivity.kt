package com.qbitscience.alarmmanagerinandroid


import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var start: Button
    lateinit var timePicker: TimePicker
    lateinit var text:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start= findViewById(R.id.button)
        timePicker = findViewById(R.id.timePicker)
         text = findViewById<EditText>(R.id.time)
        start.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            if (Build.VERSION.SDK_INT >= 23) {
                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),          calendar.get(Calendar.DAY_OF_MONTH), timePicker.hour, timePicker.minute, 0)
            }
            else {
                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), timePicker.currentHour, timePicker.currentMinute, 0)
            }
            callAlarmManager(calendar.timeInMillis)

        }


        }

    private fun callAlarmManager(timeInMillis: Long) {

        val intent = Intent(this, MyBroadcastReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this,100, intent, 0
        )
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager[AlarmManager.RTC_WAKEUP, timeInMillis] = pendingIntent
        Toast.makeText(this, "Alarm set...", Toast.LENGTH_LONG).show()


    }
}