package com.example.roomexample.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table ORDER BY first_name ASC")
    fun getAllUsers():LiveData<List<UserData>>

    @Query("SELECT * FROM user_table WHERE uid= :user_id")
    fun getUserBYId(user_id:Int):LiveData<UserData>

    @Query("SELECT * FROM user_table WHERE first_name LIKE :firsName AND last_name LIKE :lastName")
    fun finsByName(firsName:String,lastName:String):UserData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(user: List<UserData>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user:UserData)

    @Delete
    fun delete(user:UserData)

}