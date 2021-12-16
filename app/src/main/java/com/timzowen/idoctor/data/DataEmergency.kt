package com.timzowen.idoctor.data

import com.timzowen.idoctor.model.EmergencyNumbers

class DataEmergency {

    fun loadCalls() : List<EmergencyNumbers>{
        return listOf(
            EmergencyNumbers("Nairobi County", "Kijabe Hosp","0722000000"),
            EmergencyNumbers("Nakuru County","Kabarak Hosp","0721000000"),
            EmergencyNumbers("Baringo County", "Mercy Hosp","0723000000"),
            EmergencyNumbers("Mombasa County","Mediheal Hosp","0724000000"),
            EmergencyNumbers("Nairobi County", "Kijabe","0722000000"),
            EmergencyNumbers("Mombasa County","Kibaki","0721000000"),
            EmergencyNumbers("Turkana County", "Mwanga Hosp","0723000000"),
            EmergencyNumbers("Bomet County","Whales Hosp","0724000000")
        )
    }

}