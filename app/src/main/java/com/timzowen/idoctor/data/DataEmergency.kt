package com.timzowen.idoctor.data

import android.telephony.emergency.EmergencyNumber
import com.timzowen.idoctor.model.EmergencyNumbers

class DataEmergency() {

    fun loadCalls() : List<EmergencyNumbers>{
        return listOf(
            EmergencyNumbers("Nairobi", "Kijabe","0722000000"),
            EmergencyNumbers("Nakuru","Kabarak","0721000000"),
            EmergencyNumbers("Baringo", "Mercy Hosp","0723000000"),
            EmergencyNumbers("Mombasa","Mediheal","0724000000"),
            EmergencyNumbers("Nairobi", "Kijabe","0722000000"),
            EmergencyNumbers("Mombasa","Kkibaki","0721000000"),
            EmergencyNumbers("Turkana", "Mwanga Hosp","0723000000"),
            EmergencyNumbers("Bomet","Whales Hosp","0724000000")
        )
    }

}