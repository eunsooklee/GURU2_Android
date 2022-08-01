package com.example.guruapp

import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ScaleGestureDetector
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    //제스처 이벤트 감지하는 변수
    private var mScaleGestureDetector:ScaleGestureDetector?=null
    private var scaleFactor=1.0f
    private lateinit var mImageView:ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mImageView=findViewById(R.id.imageView);
        mScaleGestureDetector= ScaleGestureDetector(this,ScaleListener())

    }




    //제스처 이벤트가 발생하면 실행되는 메소드
    override fun onTouchEvent(motionEvent: MotionEvent?): Boolean {

        //제스처 이벤트를 처리하느 메소드를 호출
        mScaleGestureDetector!!.onTouchEvent(motionEvent)
        return true
    }

    //제스처 이벤트를 처리하는 클래스
    inner class ScaleListener:ScaleGestureDetector.SimpleOnScaleGestureListener()
    {
        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {

            scaleFactor *=scaleGestureDetector.scaleFactor

            scaleFactor=Math.max(0.5f,Math.min(scaleFactor,2.0f))

            mImageView.scaleX=scaleFactor
            mImageView.scaleY=scaleFactor
            return true
        }
    }



}
