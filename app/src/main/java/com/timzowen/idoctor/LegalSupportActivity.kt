package com.timzowen.idoctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.timzowen.idoctor.databinding.ActivityLegalSupportBinding
import com.timzowen.idoctor.model.LegalCase

class LegalSupportActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLegalSupportBinding
    private  lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // use view binding to avoid boiler plate code collection
        binding = ActivityLegalSupportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmitCase.setOnClickListener{

            val hospName = binding.etHospName.text.toString()
            val caseType = binding.etTypeOfCase.text.toString()
            val dateOccurrence = binding.etDateOccurrence.text.toString()
            val involvedPerson = binding.etVictimInvolved.text.toString()
            val briefDesc = binding.etBriefDesc.text.toString()

            database = FirebaseDatabase.getInstance().getReference("LegalCases")

            val LegalCase = LegalCase(hospName,caseType,dateOccurrence,involvedPerson,briefDesc)

//            database.child()

            binding.etHospName.text.clear()
            binding.etTypeOfCase.text.clear()
            binding.etDateOccurrence.text.clear()
            binding.etVictimInvolved.text.clear()
            binding.etVictimInvolved.text.clear()
            binding.etBriefDesc.text.clear()

            Toast.makeText(this,"successfuly added to db....",Toast.LENGTH_LONG).show()
        }



    }

}