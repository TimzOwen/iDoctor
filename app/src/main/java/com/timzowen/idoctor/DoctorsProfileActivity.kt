package com.timzowen.idoctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.timzowen.idoctor.adapters.DoctorsProfileAdapter
import com.timzowen.idoctor.data.DataDoctorsProfile

class DoctorsProfileActivity : AppCompatActivity(), DoctorsProfileAdapter.onItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctos_profile)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_profile_doctors)

        val dataDoctors = DataDoctorsProfile().loadDoctorsProfile()

        recyclerView.adapter = DoctorsProfileAdapter(this,dataDoctors,this)
        recyclerView.hasFixedSize()
        
    }

    override fun onItemClick(position: Int) {

        Toast.makeText(this, "You click on Doctor $position", Toast.LENGTH_SHORT).show()
    }
}