package com.timzowen.idoctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.timzowen.idoctor.data.Users
import com.timzowen.idoctor.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateUserAccount.setOnClickListener {

            val fName = binding.etUserNameSignup.text.toString()
            val age = binding.etAge.text.toString()
            val phoneNumber = binding.etPhoneNumberSignup.text.toString()

            dbRef = FirebaseDatabase.getInstance().getReference("USers")

            val user = Users(fName,age,phoneNumber)
            dbRef.child(fName).setValue(user).addOnSuccessListener {

                binding.etUserNameSignup.text.clear()
                binding.etAge.text.clear()
                binding.etPhoneNumberSignup.text.clear()

                Toast.makeText(this, "Account created....", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed, try again..", Toast.LENGTH_LONG).show()
            }
        }
    }
}