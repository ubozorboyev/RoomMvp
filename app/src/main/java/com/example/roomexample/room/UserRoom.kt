package com.example.roomexample.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors
import kotlin.concurrent.thread

@Database(entities = arrayOf(UserData::class),version = 2)
abstract class UserRoom :RoomDatabase(){
    abstract fun getUserDao():UserDao

    companion object{
        private lateinit var database:UserRoom
        fun setContext(context: Context){
            synchronized(this){
                database= Room.databaseBuilder(
                    context.applicationContext,
                    UserRoom::class.java,
                    "userdatabase")
                    .build()
            }
        }
        fun getInstanse()= database
    }
}
fun ioThrets(task:()->Unit)=Executors.newSingleThreadExecutor().execute(task)