package com.example.excercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.ConfigurationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            //val = value(num) or var = variable(calue will change)
            val car_price = editTextCarPrice.text.toString().toInt()
            val down_payment = editTextDownPayment.text.toString().toInt()
            val loan_period = editTextLoanPeriod.text.toString().toInt()
            val interest_rate = editTextInterestRate.text.toString().toFloat()
            //TODO : Continue your calculation here :^)
            //TODO : Find the locale of the user and display the currency sign
            val currentLocale = ConfigurationCompat.getLocales(resources.configuration)[0]
            if(car_price == 0 || car_price == null){
                editTextCarPrice.setError("Please enter your car price.")
            }
            val loan = car_price - down_payment
            textViewLoan.text = getString(R.string.loan) + "${loan}"
            val interest = loan * interest_rate * loan_period
            textViewInterest.text = getString(R.string.interest) + "${interest}"
            val monthly_payment = (loan + interest) / loan_period / 12
            textViewMonthlyPayment.text = getString(R.string.monthly_payment) + "${monthly_payment}"
        }
    }

    fun resetInputs(view: View) {
        //TODO : reset all inputs and outputs
        editTextCarPrice.setText("").toString()
        editTextDownPayment.setText("").toString()
        editTextInterestRate.setText("").toString()
        editTextLoanPeriod.setText("").toString()
    }
}
