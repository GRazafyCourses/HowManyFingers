package com.example.actionpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calculator_challenge.*

class CalculatorChallenge : AppCompatActivity() {

  var operationString = ""
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_calculator_challenge)
  }

  fun handleButton(view: View) {
    operationString = operationString + view.tag;
    ResultTextView.setText(operationString);
  }


  fun minus(view: View) {
    operationString = operationString + "-";
    ResultTextView.setText(operationString);
  }
  fun divide(view: View) {
    operationString = operationString + "/";
    ResultTextView.setText(operationString);
  }
  fun sum(view: View) {
    operationString = operationString + "+";
    ResultTextView.setText(operationString);
  }
  fun equal(view: View) {
    var myRegex = "([0-9]*\\.?[0-9]*)([\\+\\-\\/\\*\\^!]{1})([0-9]*\\.?[0-9]*)?".toRegex();
    var Result = 0.0
    if (myRegex.matches(operationString)){
      var matcher = myRegex.find(operationString);
      if (matcher != null) {
        when (matcher.groupValues[2]){
          "+" -> Result = matcher.groupValues[1].toDouble() + matcher.groupValues[3].toDouble();
          "-" -> Result = matcher.groupValues[1].toDouble() - matcher.groupValues[3].toDouble();
          "*" -> Result = matcher.groupValues[1].toDouble() * matcher.groupValues[3].toDouble();
          "/" -> Result = matcher.groupValues[1].toDouble() / matcher.groupValues[3].toDouble();
          "^" -> Result = powRecursive(matcher.groupValues[1].toDouble(),matcher.groupValues[3].toDouble())
          "!" -> Result = factRecursive(matcher.groupValues[1].toDouble())
        }
      }
    }
    operationString = Result.toString();
    ResultTextView.setText(Result.toString());
  }

  private fun factIterative(myVal: Double): Double {
    var res = 1.0
    for (i in 1..myVal.toInt()){
      res *= i
    }
    return res;
  }
  private fun factRecursive(myVal: Double): Double {
    if ( myVal != 0.0){
      return myVal*factRecursive(myVal-1)
    }else{
      return 1.0
    }
  }

  private fun powIterative(s: Double, s1: Double): Double {
      var res = 1.0
      for (i in 1..s1.toInt()){
        res *= s
      }
    return res
  }

  private fun powRecursive(s: Double, s1: Double): Double {
    if (s1 > 0.0){
      return s * powRecursive(s,s1-1);
    }else {
      return 1.0;
    }
  }

  fun binary2decimal(view: View) {
    var Result = 0.0
    var counter = 0
    for (e in operationString){
      if(e == '0' || e == '1'){
        Result = Result + Integer.parseInt(e.toString()).toDouble()*Math.pow(2.0,operationString.length-counter.toDouble()-1);
      }
      counter = counter + 1
    }
    ResultTextView.setText(Result.toString());
  }
  fun power(view: View) {
    operationString = operationString + "^";
    ResultTextView.setText(operationString);
  }
  fun factorial(view: View) {
    operationString = operationString + "!";
    ResultTextView.setText(operationString);
  }
  fun decimal2binary(view: View) {
    ResultTextView.setText(Integer.toBinaryString(operationString.toInt()));
  }
  fun times(view: View) {
    operationString = operationString + "*";
    ResultTextView.setText(operationString);
  }
  fun makeFloat(view: View) {
    operationString = operationString + ".";
    ResultTextView.setText(operationString);
  }

  fun reset(view: View) {
    operationString = "";
    ResultTextView.setText("");
  }
}
