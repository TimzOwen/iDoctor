package com.timzowen.idoctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.timzowen.idoctor.databinding.ActivityIdoctorBinding

class IDoctorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIdoctorBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIdoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.tbnBookCheckupDoctor.setOnClickListener {
           startActivity(Intent(this,BookAppointmentActivity::class.java))
       }
       binding.tbnBookTherapyDoctor.setOnClickListener {
           startActivity(Intent(this,BookAppointmentActivity::class.java))
       }
    }
}