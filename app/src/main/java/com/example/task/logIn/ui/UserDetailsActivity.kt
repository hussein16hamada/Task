package com.example.task.logIn.ui

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.task.R
import com.example.task.databinding.ActivityUserDetailsBinding
import im.dacer.androidcharts.PieView

import im.dacer.androidcharts.PieHelper
import im.dacer.androidcharts.PieView.OnPieClickListener
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.task.logIn.model.LogInResponse
import com.example.task.logIn.model.UserResponse
import com.example.task.logIn.viewModel.LogInViewModel

import im.dacer.androidcharts.ClockPieView
import kotlin.math.log
import kotlin.math.roundToInt

class UserDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserDetailsBinding
    lateinit var logInViewModel: LogInViewModel
    lateinit var tootal: String
    lateinit var pTootal: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_details)

        inInt()
        editActionBar()

        fillUserInfo()


    }

    private fun inInt() {
        logInViewModel = ViewModelProvider(this).get(
            LogInViewModel::class.java
        )
    }

    @SuppressLint("SetTextI18n")
    private fun fillUserInfo() {
        logInViewModel.getUserData()
        logInViewModel.userDataList.observe(this, Observer { userData ->

            binding.userName.text = userData.payroll?.employee!![0]?.eMPDATAAR
            binding.userJop.text = userData.payroll?.employee[0]?.jOBNAMEAR
            binding.date.text = userData.payroll?.date
            totalSalary(userData)
            binding.salary.text = tootal +" "+ userData.payroll.employee[0]?.cURRSYMBOLAR

            binding.neededAmount.text = (userData.payroll?.allowences?.get(0)?.sALVALUE)
                ?.plus(userData.payroll?.allowences?.get(1)?.sALVALUE!!).toString()+" "+
                    userData.payroll.employee[0]?.cURRSYMBOLAR

            binding.cutAmount.text = userData.payroll.deduction?.get(0)?.sALVALUE.toString()+" "+
                    userData.payroll.employee[0]?.cURRSYMBOLAR

            binding.totalSalaryAmount.text = tootal.toString()+" "+ userData.payroll.employee[0]?.cURRSYMBOLAR


            setPie(binding.pie, userData)

            fillTable(userData)


        })
    }

    @SuppressLint("SetTextI18n")
    private fun fillTable(userData: UserResponse) {
        binding.main.text = userData.payroll?.allowences?.get(0)?.cOMPDESCAR

        binding.mainSal.text = userData.payroll?.allowences?.get(0)?.sALVALUE.toString()+" "+
                userData.payroll?.employee?.get(0)?.cURRSYMBOLAR


        binding.work.text = userData.payroll?.allowences?.get(1)?.cOMPDESCAR
        binding.workSAl.text = userData.payroll?.allowences?.get(1)?.sALVALUE.toString()+" "+
                userData.payroll?.employee?.get(0)?.cURRSYMBOLAR

        binding.cutt.text = userData.payroll?.deduction?.get(0)?.cOMPDESCAR
        binding.cutSal.text = userData.payroll?.deduction?.get(0)?.sALVALUE.toString()+" "+
                userData.payroll?.employee?.get(0)?.cURRSYMBOLAR
    }

    private fun totalSalary(userData: UserResponse) {
        tootal = String.format(
            "%.2f", (((userData.payroll?.allowences?.get(0)?.sALVALUE)
                ?.plus((userData.payroll?.allowences?.get(1)?.sALVALUE!!))))
                ?.minus((userData.payroll?.deduction?.get(0)?.sALVALUE!!))
        ).toString()


    }

    private fun positiveTotalSalary(userData: UserResponse) {
        pTootal = String.format(
            "%.2f", (((userData.payroll?.allowences?.get(0)?.sALVALUE)
                ?.plus((userData.payroll?.allowences?.get(1)?.sALVALUE!!))))
                ?.plus((userData.payroll?.deduction?.get(0)?.sALVALUE!!))
        ).toString()


    }

    private fun editActionBar() {
        val actionBar = supportActionBar
        actionBar!!.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD)
        actionBar.setDisplayShowTitleEnabled(true)
        actionBar.setHomeButtonEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.back);
        actionBar.setTitle("راتب الموظف        ")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    fun getPercentage(count: Float, total: Float): Float {
        return (count / total) * 100.0f
    }

    private fun setPie(pieView: PieView, userData: UserResponse) {
        // TODO this lib not showing the fractions ,
        //  i did not get enough time to look for better alternative but sure there is
        positiveTotalSalary(userData)
        val pieHelperArrayList = ArrayList<PieHelper>()
        pieHelperArrayList.add(
            PieHelper(
                getPercentage(
                    (userData.payroll?.allowences?.get(0)?.sALVALUE)?.plus(
                        userData.payroll.allowences?.get(
                            1
                        )?.sALVALUE!!
                    )
                        ?.toFloat()!!,
                    pTootal.toFloat()
                ), resources.getColor(R.color.purple_700)
            )
        )

        pieHelperArrayList.add(
            PieHelper(
                getPercentage(
                    userData.payroll?.deduction?.get(0)?.sALVALUE?.toFloat()!!,
                    pTootal.toFloat()
                ), resources.getColor(R.color.yellow)
            )
        )

        pieView.setDate(pieHelperArrayList)
//        pieView.setOnPieClickListener { index ->
//            if (index != PieView.NO_SELECTED_INDEX) {
////                textView.setText("$index selected")
//            } else {
////                textView.setText("No selected pie")
//            }
//        }
//        pieView.selectedPie(2)

        pieView.selectedPie(PieView.NO_SELECTED_INDEX);
        pieView.showPercentLabel(true);
        pieView.setDate(pieHelperArrayList);
    }
}