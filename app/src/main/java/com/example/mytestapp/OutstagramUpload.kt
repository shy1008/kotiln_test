package com.example.mytestapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_outstagram_upload.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class OutstagramUpload : AppCompatActivity() {

    lateinit var  filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outstagram_upload)

        view_pictures.setOnClickListener {
            val PermissionCheck = ContextCompat.checkSelfPermission(
                this@OutstagramUpload,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
            if (PermissionCheck != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                    1001
                )
            } else{
                Toast.makeText(this,"권한이있음",Toast.LENGTH_LONG).show()
            }
            getPicture()
        }
        upload.setOnClickListener {
            uploadPost()
        }
        all_list.setOnClickListener {
            startActivity(Intent(this, PostActivity::class.java))
        }
        my_list.setOnClickListener {
            startActivity(Intent(this, OutstagramMyPostList::class.java))
        }
        user_info.setOnClickListener {
            startActivity(Intent(this, UserInfo::class.java))
        }
    }



    fun getPicture(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/*")
        startActivityForResult(intent,1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000){
            val uri : Uri = data!!.data!!
            filePath  = getImageFilePath(uri)
        }
    }

    fun getImageFilePath(contentUri: Uri): String{
        var columnIndex = 0
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(contentUri,projection,null,null,null)
        if (cursor!!.moveToFirst()){
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex)
    }

    fun uploadPost(){
        val file = File(filePath)
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"),file)
        val part = MultipartBody.Part.createFormData("image", file.name,fileRequestBody)
        val content = RequestBody.create(MediaType.parse("text/plain"),getContent())

        (application as MasterApplication).service.uploadPost(
            part,content
        ).enqueue(object : Callback<Post>{
            override fun onFailure(call: Call<Post>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if ( response.isSuccessful){
                    finish()
                    startActivity(Intent(this@OutstagramUpload,OutstagramMyPostList::class.java))
//                    val post = response.body()
//                    Log.d("pathh",post!!.content)
                }
            }
        })
    }

    fun getContent():String{
        return content_input.text.toString()
    }
}
