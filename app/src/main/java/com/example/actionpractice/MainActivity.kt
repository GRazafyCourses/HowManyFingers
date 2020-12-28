package com.example.actionpractice

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_get_value.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      user_value_to_be_passed.setText(intent.getStringExtra("valueToBePassedGetValue"))
    }

  /*fun writeToLogCat(view: View) {
    Log.i("myApp","First message from my app")
  }

  fun showTheToast(view: View) {
    var toast = Toast.makeText(this,"message for second Button",Toast.LENGTH_LONG)
    toast.setGravity(Gravity.TOP,0,300)
    var toastLayout = toast.view as LinearLayout
    toastLayout.setBackgroundColor(Color.RED)
    var toastTextView = toastLayout.getChildAt(0) as TextView
    toastTextView.textSize =  30f
    toastTextView.gravity = Gravity.CENTER_HORIZONTAL
    toastTextView.setTypeface(null,Typeface.BOLD)
    toast.show()
  }

  fun showXMLToast(view: View) {
    var toast = Toast.makeText(this,"aba",Toast.LENGTH_LONG)
    var toastLayout = layoutInflater.inflate(R.layout.custom_toast_layout,null)
    toast.view  = toastLayout
    toast.setGravity(Gravity.TOP,0,300)
    toastLayout.setBackgroundColor(Color.LTGRAY)
    toast.show()
  }

  fun WriteToEditText(view: View) {
    var myEditText = findViewById<EditText>(R.id.write_to_edit_text)
    myEditText.setText("Whatever we want")
  }*/

  fun HowManyFingersActivity(view: View) {
    var intent = Intent(this,HowManyFingersActivity::class.java)
    startActivity(intent)
  }

  fun BMIindiceActivity(view: View) {
    var intent = Intent(this,BMIChallenge::class.java)
    startActivity(intent)
  }

  fun CalculatorChallengeActivity(view: View) {
    var intent = Intent(this,CalculatorChallenge::class.java)
    startActivity(intent)
  }

  fun ListActivity(view: View) {
    var intent = Intent(this,ListActivity::class.java)
    startActivity(intent)
  }

  fun runActivityAndPassValue(view: View) {
    val intent = Intent(this, GetValueActivity::class.java)
    intent.putExtra("valueToBePassed", user_value_to_be_passed.text.toString())
    startActivity(intent)
  }



  fun spWriteTo(view: View) {
    val pref = getPreferences(Context.MODE_PRIVATE)
    val editor = pref.edit()
    editor.putString("key_text", sp_value.text.toString())
    editor.apply()
  }
  fun spReadFrom(view: View) {
    val pref = getPreferences(Context.MODE_PRIVATE)
    sp_value.setText(pref.getString("key_text", ""))
  }


}
