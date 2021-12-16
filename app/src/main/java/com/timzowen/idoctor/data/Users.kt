package com.timzowen.idoctor.data

// This is the data class that collects userNames for prescription posting by the doctors
data class Users(val firstName : String?= null,
                 val age: String?= null,
                  val phone : String ?= null) {
}