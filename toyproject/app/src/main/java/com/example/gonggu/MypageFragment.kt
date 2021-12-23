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
import com.bumptech.glide.request.target.CustomTarget
import com.example.gonggu.DTOs.userDTO
import com.example.gonggu.databinding.ActivityMypageBinding
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
import retrofit2.http.Url
import java.net.URL

class MypageFragment : Fragment() {
    //뷰 바인딩 사용
    final val RC_SIGN_IN = 1
    private var mBinding: FragmentMypageBinding? = null
    private val binding get() = mBinding!!
    lateinit var googleSignInClient : GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding= FragmentMypageBinding.inflate(inflater, container, false)

        // 데이터 받아오기
        val email = arguments?.getString("emailKey").toString()
        val name = arguments?.getString("nameKey").toString()
        val photo = arguments?.getString("photoKey").toString()
        val profileUrl = URL(photo)

        Log.d("*****성공 Frag~*****", email)
        Log.d("*****성공 Frag~*****", name)
        Log.d("*****성공 Frag~*****", photo)


        // data binding

        // email
        binding.emailProfileTxt.setText(email)

        // name
        binding.nameProfileText.setText(name)

        // profile image
        var image_task: URLtoBitmapTask = URLtoBitmapTask()
        image_task = URLtoBitmapTask().apply {
            url = URL(photo)
        }

        var bitmap: Bitmap = image_task.execute().get()

        Glide.with(this).load(bitmap).circleCrop().into(binding.ivProfileImg)


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

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding=null
    }
}