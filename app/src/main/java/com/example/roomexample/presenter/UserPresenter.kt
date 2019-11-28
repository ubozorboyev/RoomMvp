package com.example.roomexample.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.roomexample.room.UserData
import com.example.roomexample.ui.MainView

class UserPresenter (private val mainView: MainView, val modelData: ModelData, val lifecycleOwner: LifecycleOwner)
    :UserPresenterInterface{

    override fun onResume() {
          setUserData()
          mainView.showProgress()
        postDelayed(5000) {
            loadItems()
        }
    }

    override fun onClickItem(user: UserData) {
          mainView.setOnClickItem(user)
    }

    fun addClickButton(){
          modelData.insert(UserData(0,"FistName","LastName"))
    }

    fun loadItems(){
          modelData.getAllUsers().observe(lifecycleOwner, Observer {
          if (it.isNullOrEmpty()){
           setUserData()
          }
          mainView.apply {
          setItems(it)
          hideProgress()
          }
        })
    }
    fun setUserData(){
          val list= mutableListOf<UserData>()
          for (i in 0..30){
          list.add(UserData(i,"Ulug'bek ","Bozorboyev"))
          }
          modelData.insertAll(list)
        }
}