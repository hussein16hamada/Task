package com.example.task.logIn.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.task.R
import com.example.task.databinding.ActivityMainBinding
import com.example.task.logIn.viewModel.LogInViewModel
import kotlinx.coroutines.flow.collect

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var logInViewModel: LogInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

       inInt()
        clickListeners()


    }

    private fun clickListeners() {
        // TODO show progress bar while loading
        binding.signIn.setOnClickListener {
            logInViewModel.logInUser(
                // TODO validation
                binding.mobilNumber.editText?.text?.toString()!!,
                binding.password.editText?.text?.toString()!!.toInt()
            )



            logInViewModel.userLoggInDataList.observe(this, Observer { userDataLis ->
                Toast.makeText(this@LogInActivity, userDataLis.arabicMessage, Toast.LENGTH_SHORT).show()

                    if (userDataLis.success==true){
                        val intent=Intent(this,UserDetailsActivity::class.java)
//                        intent.putExtra("user",userDataLis)
                        finish()
                        startActivity(intent)

                    }else{
                        // TODO Hide  the progress bar
                    }

            })

        }
    }

    private fun inInt() {
        logInViewModel = ViewModelProvider(this).get(
            LogInViewModel::class.java
        )
    }
}