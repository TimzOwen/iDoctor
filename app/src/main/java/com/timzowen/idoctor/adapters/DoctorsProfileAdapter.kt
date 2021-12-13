package com.timzowen.idoctor.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timzowen.idoctor.R
import com.timzowen.idoctor.model.DoctorsProfile

class DoctorsProfileAdapter (private val mDoctorsList : List<DoctorsProfile>) : RecyclerView.Adapter<DoctorsProfileAdapter.ViewHolder>(){

    class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView){
        val imageProfile : ImageView = itemView.findViewById(R.id.iv_doctor_profile)
        val imageChatIcon : ImageView = itemView.findViewById(R.id.iv_chat_counsel_iconImage)
        val tvDoctorName : TextView = itemView.findViewById(R.id.doctor_chat_userName)
        val tvQuote : TextView = itemView.findViewById(R.id.tv_quote_chat_doctor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorsProfileAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.doctor_profile_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorsProfileAdapter.ViewHolder, position: Int) {
        //get the current doctor profile and match to the layout
        val currentDoctor = mDoctorsList[position]

        holder.imageProfile.setImageResource(currentDoctor.imageProfile)
        holder.imageChatIcon.setImageResource(R.drawable.ic_baseline_chat_bubble_24)
        holder.tvDoctorName.text = currentDoctor.doctorName
        holder.tvQuote.text = currentDoctor.quote
    }

    override fun getItemCount(): Int {
        return mDoctorsList.size
    }


}