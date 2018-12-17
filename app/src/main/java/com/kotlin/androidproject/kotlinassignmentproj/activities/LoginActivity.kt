package com.kotlin.androidproject.kotlinassignmentproj.activities

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.kotlin.androidproject.kotlinassignmentproj.R
import com.kotlin.androidproject.kotlinassignmentproj.databinding.ActivityLoginBinding
import com.kotlin.androidproject.kotlinassignmentproj.roomDB.AppDatabase
import com.kotlin.androidproject.kotlinassignmentproj.roomDB.User
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.button.setOnClickListener {
            doAsync {
                val res: User = AppDatabase.getInstance(this@LoginActivity).UserDao().login(binding.emailLoginId.text.toString(), binding.passwordLoginId.text.toString())


                uiThread {
                    if (binding.passwordLoginId.text.toString() == res.password && binding.emailLoginId.text.toString() == res.email ) {
                        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        intent.putExtra("user", res)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this@LoginActivity,"Please check Your Email/Password",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.signId.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.textViewUserList.setOnClickListener {
            startActivity(Intent(this@LoginActivity, DisplayActivity::class.java))
        }

        binding.textViewForgetPsd.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgetPasswordActivity::class.java))
        }
    }
}


