package com.example.actionpractice

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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

  fun writeToLogCat(view: View) {
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
  }

  fun HowManyFingersActivity(view: View) {
    var intent = Intent(this,HowManyFingersActivity::class.java)
    startActivity(intent)
  }

  fun BMIindiceActivity(view: View) {
    var intent = Intent(this,BMIChallenge::class.java)
    startActivity(intent)
  }
}
