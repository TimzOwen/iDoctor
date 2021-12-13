package com.timzowen.idoctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.timzowen.idoctor.adapters.GroupTherapyAdapter
import com.timzowen.idoctor.model.GroupTherapy

class GroupTherapyActivity : AppCompatActivity() {

    //declare all the global database variables here
    private  lateinit var dbRef : DatabaseReference
    private lateinit var userRecyclerView : RecyclerView
    private lateinit var userArrayList: ArrayList<GroupTherapy>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_therapy)

        // set the recyclerView to use linear layout and have fixed size to avoid out of range
        userRecyclerView  = findViewById(R.id.recycler_groupTherapy)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.hasFixedSize()

        userArrayList = arrayListOf<GroupTherapy>()

        getUserData()

    }

    //create a function to fetch links and data from firebase
    private fun getUserData(){
        dbRef = FirebaseDatabase.getInstance().getReference("ZoomMeetings")

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val user = userSnapshot.getValue(GroupTherapy::class.java)
                        userArrayList.add(user!!)
                    }
                    userRecyclerView.adapter = GroupTherapyAdapter(userArrayList)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                //Toast a network error
            }
        })
    }


}