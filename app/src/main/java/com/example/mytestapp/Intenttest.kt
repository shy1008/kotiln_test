package com.example.mytestapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent.*
import java.net.URL

class Intenttest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)


        intent1.setOnClickListener {
            val intent = Intent(this@Intenttest, Intent2::class.java)
            intent.apply {
                this.putExtra("key", "name1")
                this.putExtra("key2", "name2")
            }
            startActivityForResult(intent, 100)
        }

        intent3.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent)
        }



        button2.setOnClickListener {
            val hoho = edit_text.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(hoho))
            Log.d("data", "" + hoho)
            startActivity(intent)

        }

//        edittext에 입력되면서 발생하는 리스너
        edit_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString() == "abc") {
                    Log.d("edit", "text is abc")
                }
                Log.d("edit", "afterTextChanged" + s)
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("edit", "beforeTextChanged" + s)
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("edit", "onTextChanged" + s)
            }
        })



        btn.setOnClickListener {
            val edt_id = edt_id.text.toString()
            val edt_pw = edt_pw.text.toString()

            val intent = Intent(this@Intenttest,Intent2::class.java)
            intent.apply {
                this.putExtra("login_id",edt_id)
                this.putExtra("login_pw",edt_pw)
            }
            startActivityForResult(intent,1001)
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 100) {
            Log.d("data", "111")
            Log.d("data", "" + requestCode)
            Log.d("data", "" + resultCode)
            val result = data?.getStringExtra("data")
            Log.d("data", result)

        } else {
            Log.d("logout","정상 로그아웃입니다.")

        }


        super.onActivityResult(requestCode, resultCode, data)
    }
}

