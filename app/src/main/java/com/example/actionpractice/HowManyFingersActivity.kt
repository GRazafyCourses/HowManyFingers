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
    var edtText = findViewById<EditText>(R.id.write_to_edit_text)
    var txtViResult = findViewById<TextView>(R.id.ResultEdt)

    var firstDice = findViewById<ImageView>(R.id.firstDice)
    var secondDice = findViewById<ImageView>(R.id.secondDice)

    val value = Integer.parseInt(edtText.text.toString())
    var text2print = ""
    var myColor = Color.RED

    var firstDiceValue = (1..randomNumber-1).random()
    var secondDiceValue = 1
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

    var idFirstDice = getMyDrawable(firstDiceValue)
    var idSecondDice = getMyDrawable(secondDiceValue)
    Log.i("myApp","First Dice Value: $firstDiceValue")
    Log.i("myApp","Second Dice Value: $secondDiceValue")
    Log.i("myApp","First Dice Id: $idFirstDice")
    Log.i("myApp","Second Dice Id: $idSecondDice")
    firstDice.setImageResource(idFirstDice)
    secondDice.setImageResource(idSecondDice)


    if ( value == randomNumber ){
      text2print = "Yeah !!, You Win!, I'm showing: $randomNumber"

      myColor = Color.GREEN
    }else{
      text2print = "No!, You Lost!, I'm showing: $randomNumber"
    }
    txtViResult.setTextColor(myColor)
    txtViResult.setText(text2print)
  }
}
