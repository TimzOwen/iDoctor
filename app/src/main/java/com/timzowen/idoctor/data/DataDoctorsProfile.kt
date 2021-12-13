package com.timzowen.idoctor.data

import com.timzowen.idoctor.R
import com.timzowen.idoctor.model.DoctorsProfile

class DataDoctorsProfile {

    // temp data for lead counselors

    fun loafDoctorsProfile(): List<DoctorsProfile> {
        return listOf(
            DoctorsProfile(
                R.drawable.doctor1,
                "Dr. Timz Owen",
                R.drawable.ic_baseline_chat_bubble_24,
                "Health is welath",
            ),
            DoctorsProfile(
                R.drawable.doctor2,
                "Dr. Allan Kipkosgei",
                R.drawable.ic_baseline_chat_bubble_24,
                "Health is everything",
            ),
            DoctorsProfile(
                R.drawable.doctor3,
                "DR. Marini Clement",
                R.drawable.ic_baseline_chat_bubble_24,
                "We cure God heals",
            ),
            DoctorsProfile(
                R.drawable.doctor4,
                "Dr. Julia",
                R.drawable.ic_baseline_chat_bubble_24,
                "Therapy solves it",
            ),
            DoctorsProfile(
                R.drawable.doctor5,
                "Dr. Esther",
                R.drawable.ic_baseline_chat_bubble_24,
                "Health eating is all",
            ),
            DoctorsProfile(
                R.drawable.group1,
                "Dr. Irene",
                R.drawable.ic_baseline_chat_bubble_24,
                "We are family medicine",
            ),
            DoctorsProfile(
                R.drawable.group3,
                "Dr. Kamau",
                R.drawable.ic_baseline_chat_bubble_24,
                "Let's talk about us",
            ),
            )

    }
}