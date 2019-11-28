package com.example.roomexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.roomexample.R
import com.example.roomexample.presenter.UserPresenter
import com.example.roomexample.presenter.ModelData
import com.example.roomexample.room.UserData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {
private val presenter by lazy { UserPresenter(this,
    ModelData(),this)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabButton.setOnClickListener {
            presenter.addClickButton()
        }

    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun showProgress() {
        progressBar.visibility= View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility= View.GONE
    }

    override fun setItems(items: List<UserData>) {
        val adapter=UserAdapter()
        recView.adapter=adapter
        adapter.setItems(items)
        adapter.listener=presenter::onClickItem
    }

    override fun setOnClickItem(user: UserData) {
        Toast.makeText(this,user.firstName,Toast.LENGTH_SHORT).show()
    }
}
