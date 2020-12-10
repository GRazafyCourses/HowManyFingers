package com.example.actionpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_b_m_i_challenge.*
import android.widget.TextView

class BMIChallenge : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_b_m_i_challenge)
  }

  fun showBMI(view: View) {
    val valueMass = ((edit_text_mass.text.toString())).toDouble()
    val valueHeight = ((edit_text_height.text.toString())).toDouble()

    val bmiIndice = valueMass/(valueHeight*valueHeight)

    val drawableID = when {
      bmiIndice < 18.5 -> R.drawable.underweight
      18.5 < bmiIndice &&  bmiIndice < 24.9 -> R.drawable.healthy
      25 < bmiIndice  &&  bmiIndice < 29.9 -> R.drawable.overweight
      30 < bmiIndice  &&  bmiIndice < 34.9 -> R.drawable.obesity
      else -> 0
    }

    imageBMI.setImageResource(drawableID)
  }
}
