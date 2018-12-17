package com.kotlin.androidproject.kotlinassignmentproj.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.kotlin.androidproject.kotlinassignmentproj.R
import com.kotlin.androidproject.kotlinassignmentproj.roomDB.User

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val user : User = intent.getSerializableExtra("user") as User

        findViewById<TextView>(R.id.textView_name).text = user.name
    }
}
