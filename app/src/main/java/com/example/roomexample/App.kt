package com.example.roomexample

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomexample.room.UserRoom

class App :Application(){

    override fun onCreate() {
        super.onCreate()
         UserRoom.setContext(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        UserRoom.getInstanse().close()
    }
}