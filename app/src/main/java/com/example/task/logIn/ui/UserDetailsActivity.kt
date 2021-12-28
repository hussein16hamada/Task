package com.example.task.logIn.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.task.R
import com.example.task.databinding.ActivityUserDetailsBinding
import im.dacer.androidcharts.PieView

import im.dacer.androidcharts.PieHelper
import im.dacer.androidcharts.PieView.OnPieClickListener
import android.view.View
import androidx.appcompat.app.ActionBar

import im.dacer.androidcharts.ClockPieView
class UserDetailsActivity : AppCompatActivity() {
    lateinit var binding:ActivityUserDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil. setContentView(this,R.layout.activity_user_details)

        editActionBar()


        set(binding.pie)

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
    fun  getPercentage(count :Float,total:Float):Float{
       return (count / total) * 100
    }
    private fun set(pieView: PieView) {
        val pieHelperArrayList = ArrayList<PieHelper>()
        pieHelperArrayList.add(PieHelper(getPercentage(
            binding.neededAmount.text.toString().toFloat(),
            binding.totalSalaryAmount.text.toString().toFloat()), resources.getColor(R.color.purple_700)))

        pieHelperArrayList.add(PieHelper(getPercentage(
            binding.cutAmount.text.toString().toFloat(),
            binding.totalSalaryAmount.text.toString().toFloat()), resources.getColor(R.color.yellow)))

        pieView.setDate(pieHelperArrayList)
        pieView.setOnPieClickListener { index ->
            if (index != PieView.NO_SELECTED_INDEX) {
//                textView.setText("$index selected")
            } else {
//                textView.setText("No selected pie")
            }
        }
        pieView.selectedPie(2)

        pieView.selectedPie(PieView.NO_SELECTED_INDEX);
        pieView.showPercentLabel(true);
        pieView.setDate(pieHelperArrayList);
    }
}