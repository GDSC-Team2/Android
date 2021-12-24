package com.example.gonggu

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.gonggu.DTOs.userDTO
import com.example.gonggu.databinding.ActivityFavoriteBinding.inflate
import com.example.gonggu.databinding.ActivityMypageBinding
import com.example.gonggu.databinding.FragmentMainDetailBinding
import com.example.gonggu.databinding.FragmentMypageBinding
import com.example.gonggu.retrofit.RetrofitManager
import com.example.gonggu.utils.URLtoBitmapTask
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.fragment_mypage.*
import java.net.URL

class MypageFragment : Fragment() {
    //뷰 바인딩 사용
    private var mBinding: FragmentMypageBinding? = null
    private val binding get() = mBinding!!
    lateinit var googleSignInClient : GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding= FragmentMypageBinding.inflate(inflater, container, false)

        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        var mGoogleSignInClient = GoogleSignIn.getClient(activity, gso)

        googleSignInClient = GoogleSignIn.getClient(activity,gso)

        binding.logoutBtn.setOnClickListener {
            mGoogleSignInClient.signOut()
            startActivity(Intent(activity, LoginActivity::class.java))
        }

        // MainActiviy에서 데이터 값 받아오기
        var email = arguments?.getString("emailKey").toString()
        var name = arguments?.getString("nameKey").toString()
        var photo = arguments?.getString("photoKey").toString()

        Log.d("*****성공 Frag*****", "value:" + email)
        Log.d("*****성공 Frag*****", "value:" + name)
        Log.d("*****성공 Frag*****", "value:" + photo)

        // Data Binding
        binding.nameProfileText.setText(name)
        binding.emailProfileTxt.setText(email)

        // 프로필 이미지 설정
        var image_task: URLtoBitmapTask = URLtoBitmapTask()
        image_task = URLtoBitmapTask().apply {
            url = URL(photo)
        }
        var bitmap: Bitmap = image_task.execute().get()
        Glide.with(this).load(bitmap).circleCrop().into(binding.ivUserProfile)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding=null
    }
}