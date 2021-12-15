package com.timzowen.idoctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.timzowen.idoctor.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCallEmergency.setOnClickListener {
            startActivity(Intent(this,EmergencyActivity::class.java))
        }
        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}