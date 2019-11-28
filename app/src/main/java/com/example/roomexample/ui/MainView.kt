package com.example.roomexample.ui

import com.example.roomexample.room.UserData

interface MainView {
      fun showProgress()
      fun hideProgress()
      fun setItems(items:List<UserData>)
      fun setOnClickItem(user:UserData)
}