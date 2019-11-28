package com.example.roomexample.presenter

import android.os.Handler
import androidx.lifecycle.LiveData
import com.example.roomexample.room.UserDao
import com.example.roomexample.room.UserData
import com.example.roomexample.room.UserRoom
import com.example.roomexample.room.ioThrets
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ModelData: UserDao {
private val database= UserRoom.getInstanse()
private val userDao=database.getUserDao()


    override fun insert(user: UserData) {
        ioThrets {
            userDao.insert(user)
        }
    }

    override  fun insertAll(user: List<UserData>) {
        GlobalScope.launch {
            userDao.insertAll(user)
        }
    }

    override fun getAllUsers(): LiveData<List<UserData>> {
        return userDao.getAllUsers()
    }

    override fun getUserBYId(user_id: Int): LiveData<UserData> {
            return userDao.getUserBYId(user_id)
    }

    override fun finsByName(firsName: String, lastName: String) : UserData {
        return userDao.finsByName(firsName,lastName)
    }

    override fun delete(user: UserData) {
        userDao.delete(user)
    }
}


fun postDelayed(delaMillis:Long,task:()->Unit){
    Handler().postDelayed(task,delaMillis)
}
