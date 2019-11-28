package com.example.roomexample

import android.util.Log

class Extention :Thread(){

    override fun run() {
      print(Thread.currentThread().name)
    }
}
fun main(){
    val ext=Extention()
    ext.start()
}
