package com.timzowen.idoctor.model

import androidx.annotation.DrawableRes

data class DoctorsProfile(@DrawableRes val imageProfile : Int, val doctorName : String,
                           @DrawableRes val chatIcon : Int, val quote : String) {
}