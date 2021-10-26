package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
//import android.widget.TextView
//import android.widget.Toast

/**
 * this activity allows a user to roll a dice and view the result on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btnRoll)
        rollButton.setOnClickListener {
            rollDice()
        }
        rollDice()
    }

    /**
     * roll the dice and update the screen with the results
     */
    private fun rollDice() {
        /**
         *  create new Dice object with 6 sides and roll the dice
         *  when {} -> determine which drawable resource ID to use based on the dice roll
         *  setImageResource() -> update the ImageView with the correct drawable resource ID
         *  contentDescription() -> update the content description for every imageView
         */
        val dice = Dice(6)
        val diceRoll = dice.roll()
//        val luckyNum = (1..6).random()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}}