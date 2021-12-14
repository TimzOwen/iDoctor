package com.timzowen.idoctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.timzowen.idoctor.databinding.ActivityPrescriptionBinding

class PrescriptionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPrescriptionBinding
    private lateinit var db : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}