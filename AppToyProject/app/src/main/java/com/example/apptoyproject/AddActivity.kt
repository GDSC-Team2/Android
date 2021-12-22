package com.example.gonggu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gonggu.databinding.FragmentAddPostBinding
import com.example.gonggu.retrofit.RetrofitManager

//글쓰기 activity
class AddActivity : AppCompatActivity() {

    //뷰 바인딩 사용
    private var mBinding: FragmentAddPostBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //레이아웃과 연결
        mBinding = FragmentAddPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //공구 등록하기 버튼이 클릭되었을 때
        binding.createGoggu.setOnClickListener{
            var title=binding.etWriteTitle.text.toString()
            var description=binding.etWriteContent.text.toString()
            var link=binding.etProductLink.text.toString()
            var contact=binding.etOpenchatlink.text.toString()
            var date=binding.etDate.text.toString()
            //var product=binding.etProduct.text.toString()
            //var price=binding.etPrice.text.toString()
            RetrofitManager.instance.write(title,description,link,contact,date)
        }
    }

    //액티비티 파괴될 때 binding class 인스턴스 참조 정리
    override fun onDestroy() {
        mBinding=null
        super.onDestroy()
    }
}