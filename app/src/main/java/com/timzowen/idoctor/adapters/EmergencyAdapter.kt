package com.timzowen.idoctor.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timzowen.idoctor.R
import com.timzowen.idoctor.model.EmergencyNumbers

class EmergencyAdapter (
    private val context : Context,
    private val mList : List<EmergencyNumbers>,
    private val listener : onItemClickListener): RecyclerView.Adapter<EmergencyAdapter.ViewHolder>() {

    inner class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView), View.OnClickListener{

        val tvCounty :TextView = itemView.findViewById(R.id.tv_county)
        val tvTown : TextView = itemView.findViewById(R.id.tv_emergency_hosp_town)

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

    //create view Holder to bind the layout created in the user interface
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.emergeny_layout_list, parent,false)
        return ViewHolder(view)
    }

    // get current number, county and hospital and map int to the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNumber = mList[position]
        holder.tvCounty.text =currentNumber.county
        holder.tvTown.text = currentNumber.town
    }

    // get the total list of numbers in the arrays
    override fun getItemCount() =mList.size

    interface onItemClickListener{

        fun onItemClick(position: Int)
    }
}