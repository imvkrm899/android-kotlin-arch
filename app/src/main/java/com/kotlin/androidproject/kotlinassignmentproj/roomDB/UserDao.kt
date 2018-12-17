package com.kotlin.androidproject.kotlinassignmentproj.roomDB

import android.arch.persistence.room.*

@Dao
interface UserDao {
    @Query("select * from user")
    fun getAllUser(): List<User>

    @Insert
    fun insertUser(user: User)

    @Delete
    fun delete(user: User)

    @Query("UPDATE user SET password = :new_password where email =:userEmail")
    fun updatePassword(userEmail: String, new_password: String)


    @Query("select * from user where email =:userEmail AND password =:userPassword")
    fun login(userEmail: String, userPassword: String): User

}