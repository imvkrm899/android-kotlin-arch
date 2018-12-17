package com.kotlin.androidproject.kotlinassignmentproj.activities


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlin.androidproject.kotlinassignmentproj.R
import com.kotlin.androidproject.kotlinassignmentproj.adapter.DisplayAdapter
import com.kotlin.androidproject.kotlinassignmentproj.roomDB.AppDatabase
import com.kotlin.androidproject.kotlinassignmentproj.roomDB.User
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DisplayActivity : AppCompatActivity() {
    val tag: String = "display activity"
    private lateinit var users: List<User>
    lateinit var displayAdapter: DisplayAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        users = ArrayList()
        recyclerView = findViewById(R.id.recylerView_user_list)
        recyclerView.layoutManager = LinearLayoutManager(this)




        doAsync {
            users = AppDatabase.getInstance(this@DisplayActivity).UserDao().getAllUser()
            uiThread {
                displayAdapter = DisplayAdapter(this@DisplayActivity, users)
                recyclerView.adapter = displayAdapter
            }
        }
    }
}
