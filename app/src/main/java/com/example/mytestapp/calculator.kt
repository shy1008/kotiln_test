package com.example.mytestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.activity_calculator.view.*

class calculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)


        var first = "0"
        var last = "0"

        num1.setOnClickListener {
            first += "1"
            result.setText(first)
        }
        num2.setOnClickListener {
            first += "2"
            result.setText(first)
        }
        num3.setOnClickListener {
            first += "3"
            result.setText(first)
        }
        num4.setOnClickListener {
            first += "4"
            result.setText(first)
        }
        num5.setOnClickListener {
            first += "5"
            result.setText(first)
        }
        num6.setOnClickListener {
            first += "6"
            result.setText(first)
        }
        num7.setOnClickListener {
            first += "7"
            result.setText(first)
        }
        num8.setOnClickListener {
            first += "8"
            result.setText(first)
        }
        num9.setOnClickListener {
            first += "9"
            result.setText(first)
        }
        CA.setOnClickListener {
            first = "0"
            last = "0"
            result.setText("0")

        }
        plus.setOnClickListener {
            last = (first.toInt() + last.toInt()).toString()
            first = "0"
            result.setText(last)

        }
        zero.setOnClickListener {
            first += "0"
            result.setText(first)
        }


    }
}


