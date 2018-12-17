package com.kotlin.androidproject.kotlinassignmentproj.roomDB

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
class User constructor(name: String, email: String, password: String, phoneNo: String) : Serializable {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
    @ColumnInfo(name = "name")
    var name: String? = name
    @ColumnInfo(name = "email")
    var email: String? = email
    @ColumnInfo(name = "password")
    var password: String? = password
    @ColumnInfo(name = "phoneNo")
    var phoneNo: String? = phoneNo


}