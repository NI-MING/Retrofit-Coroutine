package com.wlk.retrofit_coroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(ProjectViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getProjectTree()
        viewModel.mProjectTreeLivaData.observe(this){
            for(i in it)
            Log.e("TAG",i.name)
        }

        viewModel.errorLivaData.observe(this){
            Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
        }

        viewModel.loadingLivaData.observe(this){
            if(it){
                //show loading
            }else{
                //dismiss loading

            }
        }

    }
}