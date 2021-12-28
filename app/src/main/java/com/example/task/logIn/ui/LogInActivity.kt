package com.example.task.logIn.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.task.R
import com.example.task.databinding.ActivityMainBinding
import com.example.task.logIn.viewModel.LogInViewModel

class LogInActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    lateinit var logInViewModel: LogInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil. setContentView(this,R.layout.activity_main)

        logInViewModel= ViewModelProvider(this).get(
            LogInViewModel::class.java
        )


       binding.signIn.setOnClickListener {
           logInViewModel.logInUser(binding.mobilNumber.editText?.text?.toString()!!.toInt(),
               binding.password.editText?.text?.toString()!!.toInt())

           logInViewModel.message.observe(this, Observer {aBoolean ->
               if (aBoolean != null) {
                   if (aBoolean) {
                       Toast.makeText(this,"logged In Successfully ", Toast.LENGTH_SHORT).show()
                       startActivity(Intent(this,UserDetailsActivity::class.java))
                   }else{
                       Toast.makeText(this,"error ", Toast.LENGTH_SHORT).show()
                   }
               }
           })
       }
    }
}