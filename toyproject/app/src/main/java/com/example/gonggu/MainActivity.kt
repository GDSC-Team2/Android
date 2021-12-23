package com.example.gonggu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gonggu.DTOs.userDTO
import com.example.gonggu.recyclerview.MainItem
import com.example.gonggu.recyclerview.MainItemAdapter
import com.example.gonggu.retrofit.RetrofitManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    var MypageFragment = MypageFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // LoginActivity에서 값 받아오기
        val email = intent.getStringExtra("emailKey").toString()
        val name = intent.getStringExtra("nameKey").toString()
        val photo = intent.getStringExtra("photoKey").toString()

        Log.d("*****성공 Main~*****", email)
        Log.d("*****성공 Main~*****", name)
        Log.d("*****성공 Main~*****", photo)

        var bundle = Bundle()
        bundle.putString("emailKey", email)
        bundle.putString("nameKey", name)
        bundle.putString("photoKey", photo)
        MypageFragment.arguments = bundle

        //bottom navigation
        bottom_navigationbar.setOnNavigationItemSelectedListener(this)
        //set default screen
        bottom_navigationbar.selectedItemId=R.id.action_home
    }

    //bottom navigation 화면 이동
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.action_home->{
                var MainDetailFragment = MainDetailFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content,MainDetailFragment).commit()
                return true
            }
            R.id.action_favorite->{
                var favoriteFragment = FavoriteFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content,favoriteFragment).commit()
                return true
            }
            R.id.action_add->{
                var AddFragment = AddFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content,AddFragment).commit()
                return true
            }
            R.id.action_mypage->{
                supportFragmentManager.beginTransaction().replace(R.id.main_content,MypageFragment).commit()
                return true
            }
        }
        return false
    }
}