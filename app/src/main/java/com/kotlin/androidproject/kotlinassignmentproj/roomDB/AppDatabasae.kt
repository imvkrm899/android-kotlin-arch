package com.kotlin.androidproject.kotlinassignmentproj.roomDB

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.widget.EditText
import com.commonsware.cwac.saferoom.SafeHelperFactory



@Database(version = 3, entities = arrayOf(User::class), exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun UserDao(): UserDao

    companion object {

        var factory :SafeHelperFactory? = null

        private var sInstance: AppDatabase? = null
        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room
                        .databaseBuilder(context.applicationContext, AppDatabase::class.java, "Admin")
                        .fallbackToDestructiveMigration()
                        .openHelperFactory(factory)
                        .build()
            }
            return sInstance!!
        }
    }
}