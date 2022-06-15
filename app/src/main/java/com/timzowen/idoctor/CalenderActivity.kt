package com.timzowen.idoctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.timzowen.idoctor.databinding.ActivityCalenderBinding

class CalenderActivity : AppCompatActivity() {

    private lateinit var calenderBinding: ActivityCalenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        calenderBinding = ActivityCalenderBinding.inflate(layoutInflater)
        setContentView(calenderBinding.root)

        calenderBinding.btnBookAppointment.setOnClickListener {
            startActivity(Intent(this, IDoctorActivity::class.java))
        }

        calenderBinding.btnBookTherapy.setOnClickListener {
            startActivity(Intent(this, IDoctorActivity::class.java))
        }

        calenderBinding.btnCheckPrescription.setOnClickListener {
            startActivity(Intent(this,PrescriptionActivity::class.java))
        }

    }
}