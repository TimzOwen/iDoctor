package com.timzowen.idoctor

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.timzowen.idoctor.adapters.GroupTherapyAdapter
import com.timzowen.idoctor.model.GroupTherapy

class GroupTherapyActivity : AppCompatActivity(), GroupTherapyAdapter.onItemClickListener {

    // Declare all the global database variables here
    private  lateinit var dbRef : DatabaseReference
    private lateinit var userRecyclerView : RecyclerView
    private lateinit var userArrayList: ArrayList<GroupTherapy>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_therapy)

        // set the recyclerView to use linear layout and have fixed size to avoid out of range
        userRecyclerView = findViewById(R.id.recycler_groupTherapy)

        userRecyclerView.layoutManager = LinearLayoutManager(this)

        userArrayList = arrayListOf<GroupTherapy>()
        userRecyclerView.hasFixedSize()

        dbRef = FirebaseDatabase.getInstance().getReference("ZoomMeetings")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val user = userSnapshot.getValue(GroupTherapy::class.java)
                        userArrayList.add(user!!)
                    }
                    val adapter = GroupTherapyAdapter(this@GroupTherapyActivity,userArrayList,this@GroupTherapyActivity)
                    userRecyclerView.adapter = adapter

                }
            }

            override fun onCancelled(error: DatabaseError) {
                //Toast a network error
            }
        })

    }
    override fun onItemClick(position: Int) {
        // join Zoom meeting

    }


}