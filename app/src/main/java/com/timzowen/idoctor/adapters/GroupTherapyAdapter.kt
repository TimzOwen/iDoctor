package com.timzowen.idoctor.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timzowen.idoctor.R
import com.timzowen.idoctor.model.GroupTherapy

class GroupTherapyAdapter (private val mListZoomMeetings : ArrayList<GroupTherapy>) : RecyclerView.Adapter<GroupTherapyAdapter.ViewHolder>(){

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        val tvZoomTopic : TextView = itemView.findViewById(R.id.tv_zoomTopic)
        val tvZoomLeadDoctor : TextView = itemView.findViewById(R.id.tv_leadDoctor)
        val tvZoomDate : TextView = itemView.findViewById(R.id.tv_zoomDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupTherapyAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.group_therapy_layout,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GroupTherapyAdapter.ViewHolder, position: Int) {
        val currentZoomMeeting = mListZoomMeetings[position]

        holder.tvZoomTopic.text = currentZoomMeeting.topic
        holder.tvZoomLeadDoctor.text = currentZoomMeeting.leadDoctor
        holder.tvZoomDate.text = currentZoomMeeting.date

    }

    // return the number of cards in the zoom meeting
    override fun getItemCount(): Int {
        return mListZoomMeetings.size
    }



}

