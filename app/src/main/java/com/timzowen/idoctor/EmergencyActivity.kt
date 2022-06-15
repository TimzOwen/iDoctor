package com.timzowen.idoctor

import android.content.Intent
import android.net.Uri
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
        when(position){
            0 ->{
                // pull the contact and extra to phone log
               val nairobiHospital = Intent(Intent.ACTION_CALL)
                nairobiHospital.data = Uri.parse("tel" + "0722000000")
                startActivity(nairobiHospital)
            }
            1 ->{
                val kabarakHospital = Intent(Intent.ACTION_CALL)
                kabarakHospital.data = Uri.parse("tel" + "0721000000")
                startActivity(kabarakHospital)
            }
            2 -> {
                val mercyHosp = Intent(Intent.ACTION_CALL)
                mercyHosp.data = Uri.parse("tel" + "0723000000")
                startActivity(mercyHosp)

            }
            3 -> {
                val mediHeal = Intent(Intent.ACTION_CALL)
                mediHeal.data = Uri.parse("tel" + "0724000000")
                startActivity(mediHeal)
            }
        }
    }
}