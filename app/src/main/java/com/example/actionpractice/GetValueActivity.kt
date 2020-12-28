package com.example.actionpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_get_value.*
import kotlinx.android.synthetic.main.activity_main.*

class GetValueActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_get_value)
    passed_value.setText(intent.getStringExtra("valueToBePassed"))
  }

  fun PassValuetoMainActivity(view: View) {
    val intent = Intent(this, MainActivity::class.java)
    intent.putExtra("valueToBePassedGetValue", passed_value.text.toString())
    startActivity(intent)
  }
}
