package com.timzowen.idoctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.timzowen.idoctor.adapters.EmergencyAdapter
import com.timzowen.idoctor.data.DataEmergency

class EmergencyActivity : AppCompatActivity(),EmergencyAdapter.onItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        //get the recycler view
        val recyclerviewEmergency = findViewById<RecyclerView>(R.id.recycler_emergency)

        //get all the numbers in the emergency data package
        val dataNumbers = DataEmergency().loadCalls()

        // map all the data in the adapter
        recyclerviewEmergency.adapter = EmergencyAdapter(this,dataNumbers,this)
        recyclerviewEmergency.hasFixedSize()

    }

    override fun onItemClick(position: Int) {
        // use Dialogs here to trigger the calls
    }
}