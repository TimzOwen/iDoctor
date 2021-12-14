package com.timzowen.idoctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardLocateHospitalActivity : CardView = findViewById(R.id.card_medication)
        val cardEmergencyActivity : CardView = findViewById(R.id.card_emergency)
        val cardCalenderActivity : CardView = findViewById(R.id.card_calendar)
        val cardGroupTherapyActivity : CardView = findViewById(R.id.card_groupTherapy)
        val cardIDoctorActivity : CardView = findViewById(R.id.card_iDoctor)
        val cardLegalSupportActivity : CardView = findViewById(R.id.card_legal_support)


        // start all the activities in the main activity ->cards
        cardLocateHospitalActivity.setOnClickListener {
            startActivity(Intent(this, HospitalLocationActivity::class.java))
        }

        cardEmergencyActivity.setOnClickListener {
            startActivity(Intent(this, EmergencyActivity::class.java))
        }

        cardCalenderActivity.setOnClickListener{
            startActivity(Intent(this,SignUpActivity::class.java))
        }
        cardGroupTherapyActivity.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        cardIDoctorActivity.setOnClickListener {
            startActivity(Intent(this, DoctorsProfileActivity::class.java))
        }

        cardLegalSupportActivity.setOnClickListener{
            startActivity(Intent(this,LegalSupportActivity::class.java))
        }

    }

}