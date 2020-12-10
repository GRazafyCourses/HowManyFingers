package com.example.actionpractice

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_how_many_fingers.*
import java.util.concurrent.atomic.AtomicInteger

class HowManyFingersActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_how_many_fingers)
  }

  fun getMyDrawable(valueDice: Int): Int {
    when (valueDice)  {
      1 -> return R.drawable.dice1
      2 -> return R.drawable.dice2
      3 -> return R.drawable.dice3
      4 -> return R.drawable.dice4
      5 -> return R.drawable.dice5
      6 -> return R.drawable.dice6
    }
    return 425658
  }
  fun showNumber(view: View) {
    var randomNumber = (2..12).random()
    val value = Integer.parseInt(write_to_edit_text.text.toString())
    var text2print = ""
    var myColor = Color.RED



    var firstDiceValue = (1..randomNumber-1).random()
    var secondDiceValue = 1

    //Setting the value of each dice so i can have different one ( 6 : 3+3 or 2+4 or 4+2 or 5+1 etc...)
    if (firstDiceValue > 6){
      secondDiceValue = randomNumber - 6
      firstDiceValue = 6
    }
    else if(randomNumber > 6 && firstDiceValue < 6){
      secondDiceValue = 6
      firstDiceValue = randomNumber - 6
    }
    else{
      secondDiceValue = randomNumber - firstDiceValue
    }

    // Getting the Drawables
    var idFirstDice = getMyDrawable(firstDiceValue)
    var idSecondDice = getMyDrawable(secondDiceValue)

    // Setting the Drawables
    firstDice.setImageResource(idFirstDice)
    secondDice.setImageResource(idSecondDice)


    if ( value == randomNumber ){
      text2print = "Yeah !!, You Win!, I'm showing: $randomNumber"

      myColor = Color.GREEN
    }else{
      text2print = "No!, You Lost!, I'm showing: $randomNumber"
    }


    ResultEdt.setTextColor(myColor)
    ResultEdt.setText(text2print)
  }
}
