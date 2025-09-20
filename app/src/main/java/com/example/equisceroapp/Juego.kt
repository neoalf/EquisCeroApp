package com.example.equisceroapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Juego : AppCompatActivity() {

    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var b3: Button
    lateinit var b4: Button
    lateinit var b5: Button
    lateinit var b6: Button
    lateinit var b7: Button
    lateinit var b8: Button
    lateinit var b9: Button

    var currentPlayer:Int = 1
    var scorePlayer1:Int = 0
    var scorePlayer2:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_juego)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        initUI()

    }


private fun Juego.initUI() {
    b1 = findViewById(R.id.b1)
    b2 = findViewById(R.id.b2)
    b3 = findViewById(R.id.b3)
    b4 = findViewById(R.id.b4)
    b5 = findViewById(R.id.b5)
    b6 = findViewById(R.id.b6)
    b7 = findViewById(R.id.b7)
    b8 = findViewById(R.id.b8)
    b9 = findViewById(R.id.b9)

}
fun play(btn:View){
    val myBtn:Button = btn as Button
if(myBtn.text.toString().isEmpty()){
        if(currentPlayer == 1){
            myBtn.text = "X"
            currentPlayer = 2
        }else{

            myBtn.text = "O"
            currentPlayer = 1

            }
    }
}
}