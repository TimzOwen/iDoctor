package com.timzowen.idoctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.timzowen.idoctor.adapters.DoctorsProfileAdapter
import com.timzowen.idoctor.data.DataDoctorsProfile

class DoctorsProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctos_profile)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_profile_doctors)

        val dataDoctors = DataDoctorsProfile().loafDoctorsProfile()

        recyclerView.adapter = DoctorsProfileAdapter(dataDoctors)

    }
}