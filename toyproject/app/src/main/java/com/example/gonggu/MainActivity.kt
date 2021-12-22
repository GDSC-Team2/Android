package com.example.gonggu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gonggu.recyclerview.MainItem
import com.example.gonggu.recyclerview.MainItemAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //test recycler view
        val MainItemList= arrayListOf(
            MainItem("글제목1", "저자", "공구링크", "공구가격", "공구기간"),
            MainItem("글제목2", "저자", "공구링크", "공구가격", "공구기간"),
            MainItem("글제목3", "저자", "공구링크", "공구가격", "공구기간"),
            MainItem("글제목4", "저자", "공구링크", "공구가격", "공구기간")
        )

        rv_items.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_items.setHasFixedSize(true)

        rv_items.adapter= MainItemAdapter(MainItemList)

        //bottom navigation
        bottom_navigationbar.setOnNavigationItemSelectedListener(this)
        //set default screen
        bottom_navigationbar.selectedItemId=R.id.action_home

    }

    //bottom navigation 화면 이동
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.action_home->{
                startActivity(Intent(this, MainActivity::class.java))
                return true
            }
            R.id.action_favorite->{
                startActivity(Intent(this, FavoriteActivity::class.java))
                finish()
                return true
            }
            R.id.action_add->{
                startActivity(Intent(this, AddActivity::class.java))
                finish()
                return true
            }
            R.id.action_mypage->{
                startActivity(Intent(this, MypageActivity::class.java))
                finish()
                return true
            }
        }
        return false

    }
}