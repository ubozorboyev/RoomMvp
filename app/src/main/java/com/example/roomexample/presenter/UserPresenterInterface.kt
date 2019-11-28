package com.example.roomexample.presenter

import com.example.roomexample.room.UserData

interface UserPresenterInterface {
    fun onClickItem(user:UserData)
    fun onResume()
}