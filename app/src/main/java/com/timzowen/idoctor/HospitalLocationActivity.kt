package com.timzowen.idoctor

import android.annotation.SuppressLint
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.webkit.WebView

class HospitalLocationActivity : AppCompatActivity() {

    lateinit var progressDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_location)


        initView()

        Handler().postDelayed({
            progressDialog.dismiss()
        },6000)

    }

    //create a function to initialize the google maps API
    @SuppressLint("SetJavaScriptEnabled")
    private fun initView(){
        //find the ID to the map
        val mapview : WebView = findViewById<WebView>(R.id.wv_mapview)

        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Getting nearby hospitals.....")
        progressDialog.setCancelable(false)
        progressDialog.show()

        mapview.settings.javaScriptEnabled = true
        mapview.loadUrl("https://www.google.com/maps/@-1.262591,36.8127474,17z")
    }
}