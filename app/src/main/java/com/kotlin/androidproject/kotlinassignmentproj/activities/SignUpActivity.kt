package com.kotlin.androidproject.kotlinassignmentproj.activities

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.commonsware.cwac.saferoom.SafeHelperFactory
import com.kotlin.androidproject.kotlinassignmentproj.R
import com.kotlin.androidproject.kotlinassignmentproj.databinding.ActivitySignUpBinding
import com.kotlin.androidproject.kotlinassignmentproj.roomDB.AppDatabase
import com.kotlin.androidproject.kotlinassignmentproj.roomDB.User
import kotlinx.android.synthetic.main.activity_sign_up.view.*
import org.jetbrains.anko.doAsync


class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        var user: User
        binding.signUpId.setOnClickListener {
          AppDatabase.factory=  SafeHelperFactory.fromUser(binding.passwordId.text)

            user = User(binding.nameId.text.toString(), binding.emailId.text.toString(),binding.passwordId.text.toString(), binding.phoneNoId.text.toString())

            doAsync {
                AppDatabase.getInstance(this@SignUpActivity).UserDao().insertUser(user)
            }

            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))

        }

        binding.textViewLogin.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
        }

    }
}

