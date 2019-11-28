package com.example.roomexample.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserData(
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "uid") val uid:Int,
    @ColumnInfo(name = "first_name") val firstName:String?,
    @ColumnInfo(name = "last_name") var lastNmae:String?
)