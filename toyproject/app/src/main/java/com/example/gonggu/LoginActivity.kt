package com.example.gonggu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.gonggu.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class LoginActivity : AppCompatActivity() {

    final val RC_SIGN_IN = 1

    private var mBinding: ActivityLoginBinding? = null
    private val binding get() = mBinding!!

    lateinit var googleSignInClient : GoogleSignInClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("572171105595-nemm1l1kuqo023fq5b5053n55322qa3i.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this,gso)

        binding.loginBtn.setOnClickListener {
            googleLogin()
//            Toast.makeText(this, "성공", Toast.LENGTH_LONG).show()

//            val gsa = GoogleSignIn.getLastSignedInAccount(this@LoginActivity)

            // 로그인 되있는 경우 (토큰으로 로그인 처리)
//            if (gsa != null && gsa.id != null) {
//                startActivity(Intent(this, MainActivity::class.java))
//                finish()
//            }
        }

    }

    private fun googleLogin() {
        val signInIntent = googleSignInClient!!.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            // The Task returned from this call is always completed, no need to attach
//            // a listener.
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            handleSignInResult(task)
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account : GoogleSignInAccount = completedTask.getResult(ApiException::class.java)

            if (account != null) {
                val email = account?.email.toString()
                val familyName = account?.familyName.toString()
                val givenName = account?.givenName.toString()
                val displayName = account?.displayName.toString()

                Log.d("*******success*******", email)
                Log.d("*******success*******", familyName)
                Log.d("*******success*******", givenName)
                Log.d("*******success*******", displayName)
            }

        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("failed", "signInResult:failed code=" + e.statusCode)
        }
    }
}