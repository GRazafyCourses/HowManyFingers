package com.example.actionpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calculator_challenge.*

class CalculatorChallenge : AppCompatActivity() {
  var FirstNumber = ""
  var SecondNumber = ""
  var tmpFirstNumber = ""
  var tmpSecondNumber = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_calculator_challenge)
  }

  fun handleButton(view: View) {
    tmpFirstNumber = tmpFirstNumber + view.tag;
    ResultTextView.setText(tmpFirstNumber)
  }


  fun minus(view: View) {}
  fun divide(view: View) {}
  fun sum(view: View) {}
  fun equal(view: View) {}
  fun binary2decimal(view: View) {}
  fun power(view: View) {}
  fun factorial(view: View) {}
}
