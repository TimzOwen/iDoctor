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
        },2000)

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
        mapview.loadUrl("https://www.google.com/search?tbs=lf:1,lf_ui:4&tbm=lcl&sxsrf=AOaemvL9oD6zl54Fi9B9Z-XaevPAnR1Asg:1639472348488&q=google" +
                "+maps+kenya+hospitals&rflfq=1&num=10&sa=X&ved=2ahUKEwjh7My39uL0AhVs7OAKHTMTB2AQjGp6BAgDEDc&biw=1920&bih=947&dpr=1#rlfi=hd:;si:;mv:[[-0." +
                "2654674733999653,36.118273265434325],[-0.29945601250896203,36.053900249076904],null,[-0.28246175537936413,36.086086757255615],15]")
    }
}