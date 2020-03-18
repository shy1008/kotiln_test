package com.example.mytestapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)


//        val name =  intent.getStringExtra("key")
//        val name2 = intent.getStringExtra("key2")
//
//        Log.d("data",name)
//        Log.d("data",name2)

//        intent2.setOnClickListener {
//            val  result = name + name2
//
//            val  resultIntent = Intent()
//            resultIntent.putExtra("data",result)
//
//            setResult(Activity.RESULT_OK,resultIntent)
//            finish()
//        }


        val id =intent.getStringExtra("login_id")
        val pw =intent.getStringExtra("login_pw")

        Log.d("data",id)
        Log.d("data",pw)

        text_id.setText(id)
        text_pw.setText(pw)

        btn2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("logout","정상적 로그아웃")

            setResult(Activity.RESULT_OK,intent)
            finish()
        }




    }

}
