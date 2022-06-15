package com.timzowen.idoctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.timzowen.idoctor.databinding.ActivityPrescriptionBinding

class PrescriptionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPrescriptionBinding
    private lateinit var db : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnGetPrescription.setOnClickListener {

            val userName : String = binding.etSearchUserName.text.toString()

            if (userName.isNotEmpty()){

                sendPrescription(userName)

            }else{
                Toast.makeText(this, "Please enter Name....", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun sendPrescription(userName : String){

        db = FirebaseDatabase.getInstance().getReference("USers")
        db.child(userName).get().addOnSuccessListener {

            if (it.exists()){

                val firstName = it.child("firstName").value
                val administered = it.child("administered").value
                val medName = it.child("medname").value

                Toast.makeText(this, "Prescription Done fetching....", Toast.LENGTH_SHORT).show()

                binding.etSearchUserName.text.clear()
                binding.tvUserNamePrescription.text = firstName.toString()
                binding.etNumAdministered.text = administered.toString()
                binding.tvMedName.text = medName.toString()

            }else{
                Toast.makeText(this, "User not found.....", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {

            Toast.makeText(this, "Contact doctors....", Toast.LENGTH_SHORT).show()
        }
    }
}