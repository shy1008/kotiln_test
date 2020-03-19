package com.example.mytestapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerviewActivity : AppCompatActivity() {

    var dogList = arrayListOf<Dog>(
        Dog("제목1", "male", "23"),
        Dog("제목2", "male", "12"),
        Dog("제목3", "male", "123"),
        Dog("제목4", "male", "1234"),
        Dog("제목5", "male", "2123"),
        Dog("제목6", "male", "23"),
        Dog("제목7", "male", "212"),
        Dog("제목8", "male", "22"),
        Dog("제목9", "male", "211"),
        Dog("제목10", "male", "233"),
        Dog("제목11", "male", "244"),
        Dog("제목12", "male", "25")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        val dogAdapter = dogAdapter(dogList, LayoutInflater.from(this@RecyclerviewActivity))
        recycler_view.adapter = dogAdapter
        recycler_view.layoutManager = LinearLayoutManager(this@RecyclerviewActivity)
        recycler_view.setHasFixedSize(true)


    }


}

class dogAdapter(
    val itemList: ArrayList<Dog>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<dogAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogtitle: TextView
        val age: TextView
        val gender: TextView

        init {
            dogtitle = itemView.findViewById(R.id.dogtitle)
            age = itemView.findViewById(R.id.age)
            gender = itemView.findViewById(R.id.gender)

            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val dogintro = itemList.get(position).breed
//                Log.d("data",dogintro)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            this.dogtitle.setText(itemList.get(position).breed)
            this.age.setText(itemList.get(position).age)
            this.gender.setText(itemList.get(position).gender)
        }
    }
}