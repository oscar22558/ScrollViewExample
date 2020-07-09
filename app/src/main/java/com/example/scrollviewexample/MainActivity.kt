package com.example.scrollviewexample

import android.os.Build
import android.os.Bundle
import android.view.ViewTreeObserver
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.Button
import android.widget.HorizontalScrollView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var parentLayout: HorizontalScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        parentLayout = findViewById<HorizontalScrollView>(R.id.horizontalScrollView)
        val vto: ViewTreeObserver = parentLayout.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
            override fun onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    parentLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
                } else {
                    parentLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
                val width: Int = parentLayout.measuredWidth
                val height: Int = parentLayout.measuredHeight
                findViewById<Button>(R.id.button1).width = width
            }
        })


    }
}