package com.timzowen.idoctor.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timzowen.idoctor.R
import com.timzowen.idoctor.model.GroupTherapy

class GroupTherapyAdapter(
    private val context: Context,
    private val mListZoomMeetings: ArrayList<GroupTherapy>,
    val listener: onItemClickListener
    ) : RecyclerView.Adapter<GroupTherapyAdapter.ViewHolder>(){

    inner class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val ivZoomPic : ImageView = itemView.findViewById(R.id.iv_zoomImage)
        val tvZoomTopic : TextView = itemView.findViewById(R.id.tv_zoomTopic)
        val tvZoomLeadDoctor : TextView = itemView.findViewById(R.id.tv_leadDoctor)
        val tvZoomDate : TextView = itemView.findViewById(R.id.tv_zoomDate)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
           val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupTherapyAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.group_therapy_layout,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GroupTherapyAdapter.ViewHolder, position: Int) {
        val currentZoomMeeting = mListZoomMeetings[position]

        holder.tvZoomTopic.text = currentZoomMeeting.topic
        holder.tvZoomLeadDoctor.text = currentZoomMeeting.leader
        holder.tvZoomDate.text = currentZoomMeeting.date
        holder.ivZoomPic.setImageResource(currentZoomMeeting.zoomImage)

    }

    // return the number of cards in the zoom meeting
    override fun getItemCount(): Int {
        return mListZoomMeetings.size
    }

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

}

