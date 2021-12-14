package com.timzowen.idoctor

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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

    lateinit var progressDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // use view binding to avoid boiler plate code collection
        binding = ActivityLegalSupportBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSubmitCase.setOnClickListener{

            progressDialog = ProgressDialog(this)
            progressDialog.setMessage("Reporting case.....")
            progressDialog.setCancelable(false)
            progressDialog.show()


            val hospName = binding.etHospName.text.toString()
            val caseType = binding.etTypeOfCase.text.toString()
            val dateOccurrence = binding.etDateOccurrence.text.toString()
            val involvedPerson = binding.etVictimInvolved.text.toString()
            val briefDesc = binding.etBriefDesc.text.toString()

            database = FirebaseDatabase.getInstance().getReference("LegalCases")

            val LegalCase = LegalCase(hospName,caseType,dateOccurrence,involvedPerson,briefDesc)

            database.child(hospName).setValue(LegalCase).addOnSuccessListener {

                binding.etHospName.text.clear()
                binding.etTypeOfCase.text.clear()
                binding.etDateOccurrence.text.clear()
                binding.etVictimInvolved.text.clear()
                binding.etVictimInvolved.text.clear()
                binding.etBriefDesc.text.clear()

                Toast.makeText(this,"successfully reported....",Toast.LENGTH_LONG).show()


                Handler().postDelayed({
                    progressDialog.dismiss()
                },8000)

                progressDialog.dismiss()

            }.addOnFailureListener {

                Toast.makeText(this,"Failed. Try again..",Toast.LENGTH_LONG).show()
                progressDialog.dismiss()

            }


        }



    }

}