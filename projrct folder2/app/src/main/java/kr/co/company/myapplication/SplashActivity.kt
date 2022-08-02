package kr.co.company.myapplication

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity
import kr.co.company.myapplication.R.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_splash)
        val x = Handler()
        x.postDelayed(SplashHandler(), 1000) //1초 후에 SplashHandler클래스 호출
    }

    inner class SplashHandler : Runnable {
        override fun run() {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}