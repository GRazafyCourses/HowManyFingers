package com.example.actionpractice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_change_flower.*
import kotlinx.android.synthetic.main.activity_main.*

class ChangeFlower : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_change_flower)
    name_flower.setText(intent.getStringExtra("valueToBePassed"))
  }

  fun changeNames(view: View) {
    val intent = Intent()
    intent.putExtra("editTextValue", name_flower.text.toString())
    setResult(RESULT_OK, intent)
    finish()
  }


  fun writeFromSharedPreferences(view: View) {
    val pref = getPreferences(Context.MODE_PRIVATE)
    val editor = pref.edit()
    editor.putString(name_flower.text.toString(), name_flower.text.toString())
    editor.apply()}
  fun readFromSharedPreferences(view: View) {
    val pref = getPreferences(Context.MODE_PRIVATE)
    name_flower.setText(pref.getString(name_flower.text.toString(), ""))
  }
}
