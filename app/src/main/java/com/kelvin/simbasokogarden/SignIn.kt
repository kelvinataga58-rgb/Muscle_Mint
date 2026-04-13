package com.kelvin.simbasokogarden

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams


class SignIn : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


//        Mpesa:   http://papii.alwaysdata.net/api/mpesa_payment
//        get products:    http://papii.alwaysdata.net/api/getproductdetails
//        SignIN:    http://papii.alwaysdata.net/api/signin
//            signup:  http://papii.alwaysdata.net/api/signup
        }

        val signin=findViewById<TextView>(R.id.siginin_link)

        signin.setOnClickListener{
            val signInlink= Intent(applicationContext, SignUp::class.java)
            startActivity(signInlink)
        }

        val email=findViewById<EditText>(R.id.email)
        val password=findViewById<EditText>(R.id.password)

        val siginbutton=findViewById<Button>(R.id.signin_button)
        siginbutton.setOnClickListener {
            val api="http://papii.alwaysdata.net/api/signin"

//            request params is the container used to collect the users details its like from data in js
            val data = RequestParams()

            data.put("email",email.text.toString())
            data.put("password",password.text.toString().trim())

//            Api helper-it delivers our data to the api

            val helper= ApiHelper(applicationContext)
            helper.post_login(api,data)

        }
    }
}