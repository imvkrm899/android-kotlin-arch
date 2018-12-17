package com.kotlin.androidproject.kotlinassignmentproj.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.kotlin.androidproject.kotlinassignmentproj.R
import com.kotlin.androidproject.kotlinassignmentproj.roomDB.AppDatabase
import com.kotlin.androidproject.kotlinassignmentproj.roomDB.User
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.security.auth.login.LoginException


class ForgetPasswordActivity : AppCompatActivity() {
    private lateinit var users: List<User>
    lateinit var mEmail: TextInputEditText
    lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)
        users = ArrayList()

        mEmail = findViewById(R.id.change_password_email)
        findViewById<Button>(R.id.button_cng_psd).setOnClickListener {


            doAsync {
                users = AppDatabase.getInstance(this@ForgetPasswordActivity).UserDao().getAllUser()

                for (i in 0 until users.size) {

                    Log.e("userlist", "" + users[i].email)
                    if (users[i].email.equals(mEmail.text.toString())) {
                        Log.e("fd", "dfdf")
                        AppDatabase.getInstance(this@ForgetPasswordActivity).UserDao().updatePassword(users[i].email.toString(), findViewById<TextInputEditText>(R.id.changed_password).text.toString())

                        uiThread {
                            Toast.makeText(this@ForgetPasswordActivity, "Password has been Changed Successfully", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@ForgetPasswordActivity, LoginActivity::class.java))
                        }
                    } else if (i == users.size) {
                        uiThread {
                            Toast.makeText(this@ForgetPasswordActivity, "Email Doesn't exist", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@ForgetPasswordActivity, LoginActivity::class.java))
                        }
                    }
                }

            }
        }
    }
}


