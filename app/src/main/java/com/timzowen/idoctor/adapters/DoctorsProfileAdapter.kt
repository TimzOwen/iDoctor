package com.timzowen.idoctor.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timzowen.idoctor.R
import com.timzowen.idoctor.model.DoctorsProfile

class DoctorsProfileAdapter (
    private val context : Context,
    private val mDoctorsList : List<DoctorsProfile>,
    val listener: onItemClickListener) : RecyclerView.Adapter<DoctorsProfileAdapter.ItemViewHolder>(){


    inner class ItemViewHolder(private val view : View) : RecyclerView.ViewHolder(view), View.OnClickListener{
        val imageProfile : ImageView = itemView.findViewById(R.id.iv_doctor_profile)
        val imageChatIcon : ImageView = itemView.findViewById(R.id.iv_chat_counsel_iconImage)
        val tvDoctorName : TextView = itemView.findViewById(R.id.doctor_chat_userName)
        val tvQuote : TextView = itemView.findViewById(R.id.tv_quote_chat_doctor)

        init {
            itemView.setOnClickListener(this)
            }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position!=RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorsProfileAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.doctor_profile_layout,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
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

    //create an interface to listen to each click item
    interface onItemClickListener {

        fun onItemClick(position: Int)

    }


}