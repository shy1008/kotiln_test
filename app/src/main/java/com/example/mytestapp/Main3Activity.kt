package com.example.mytestapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        Log.d("life","onCreate")

        button.setOnClickListener {
//            Toast.makeText(this@Main3Activity,"안녕하세요",Toast.LENGTH_SHORT).show()
            textview.setText(R.string.nameing)
            imageview.setImageResource(R.drawable.ic_launcher_background)

        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("life","onstart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life","onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("life","onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("life","onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life","onDestroy")

    }
}
