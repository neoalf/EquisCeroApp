package com.example.equisceroapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
    lateinit var tvPlayer1: TextView
    lateinit var tvPlayer2: TextView
    lateinit var tvScorePlayer1: TextView
    lateinit var tvScorePlayer2: TextView

    var currentPlayer:Int = 1
    var scorePlayer1:Int = 0
    var scorePlayer2:Int = 0
    var gameFinished:Boolean = false


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
    tvPlayer1 = findViewById(R.id.tvPlayer1)
    tvPlayer2 = findViewById(R.id.tvPlayer2)
    tvScorePlayer1 = findViewById(R.id.tvScorePlayer1)
    tvScorePlayer2 = findViewById(R.id.tvScorePlayer2)



    tvPlayer1.text = intent ?.extras?.getString("player1").toString()
    tvPlayer2.text = intent ?.extras?.getString("player2").toString()
    nuevaPartida(tvPlayer1)

}
fun play(btn:View){
    val myBtn:Button = btn as Button
if(!gameFinished && myBtn.text.toString().isEmpty()){
        if(currentPlayer == 1){
            myBtn.text = "X"
            validateWinner(btn)
            currentPlayer = 2
            tvPlayer1.setTextColor(Color.GRAY)
            tvPlayer2.setTextColor(Color.GREEN)

        }else{

            myBtn.text = "O"
            validateWinner(btn)
            currentPlayer = 1
            tvPlayer1.setTextColor(Color.GREEN)
            tvPlayer2.setTextColor(Color.GRAY)

            }
    }
}
    fun validateWinner(btn:View){

        if(validateCards(btn)) {

            if(currentPlayer ==1){
                scorePlayer1++
                tvScorePlayer1.text = "$scorePlayer1"

                Toast.makeText(applicationContext, "${tvPlayer1.text} Ganaste !!", Toast.LENGTH_LONG).show()

            }else{
                scorePlayer2++
                tvScorePlayer2.text = "$scorePlayer2"

                Toast.makeText(applicationContext, "${tvPlayer2.text} Ganaste !!", Toast.LENGTH_LONG).show()

            }
            gameFinished = true
    }

}

    private fun validateCards(btn:View): Boolean {
        var b1Val = b1.text.toString().trim()
        var b2Val = b2.text.toString().trim()
        var b3Val = b3.text.toString().trim()
        var b4Val = b4.text.toString().trim()
        var b5Val = b5.text.toString().trim()
        var b6Val = b6.text.toString().trim()
        var b7Val = b7.text.toString().trim()
        var b8Val = b8.text.toString().trim()
        var b9Val = b9.text.toString().trim()
        var winner = false

        when (btn.id){

            b1.id-> {
                if (!b1Val.isEmpty() && (b1Val.equals(b2Val) && b1Val.equals(b3Val))
                    || (b1Val.equals(b5Val) && b1Val.equals(b9Val))
                    || (b1Val.equals(b4Val) && b1Val.equals(b7Val)))
                {
                    winner = true
                }
            }
            b2.id-> {
                if (!b2Val.isEmpty() && (b2Val.equals(b1Val) && b2Val.equals(b3Val))
                    || (b2Val.equals(b5Val) && b2Val.equals(b8Val)))
                {
                    winner = true
                }
            }
            b3.id-> {
                if (!b3Val.isEmpty() && (b3Val.equals(b1Val) && b3Val.equals(b2Val))
                    || (b3Val.equals(b6Val) && b3Val.equals(b9Val))
                    || (b3Val.equals(b5Val) && b3Val.equals(b7Val)))
                {
                    winner = true
                }
            }
            b4.id-> {
                if (!b4Val.isEmpty() && (b4Val.equals(b1Val) && b4Val.equals(b7Val))
                    || (b4Val.equals(b5Val) && b4Val.equals(b6Val)))
                {
                    winner = true
                }
            }
            b5.id-> {
                if (!b5Val.isEmpty() && (b5Val.equals(b2Val) && b5Val.equals(b8Val))
                    || (b5Val == b4Val && b5Val.equals(b6Val))
                    || (b5Val.equals(b1Val) && b5Val.equals(b9Val))
                    || (b5Val.equals(b3Val) && b5Val.equals(b7Val)))
                {
                    winner = true
                }
            }
            b6.id-> {
                if (!b6Val.isEmpty() && (b6Val.equals(b3Val) && b6Val.equals(b9Val))
                    || (b6Val.equals(b4Val) && b6Val.equals(b5Val)))
                {
                    winner = true
                }
            }
            b7.id-> {
                if (!b7Val.isEmpty() && (b7Val.equals(b1Val) && b7Val.equals(b4Val))
                    || (b7Val.equals(b3Val) && b7Val.equals(b5Val))
                    || (b7Val.equals(b8Val) && b7Val.equals(b9Val)))
                {
                    winner = true
                }
            }
            b8.id-> {
                if (!b8Val.isEmpty() && (b8Val.equals(b7Val) && b8Val.equals(b9Val))
                    || (b8Val.equals(b2Val) && b8Val.equals(b5Val)))
                {
                    winner = true
                }
            }
            b9.id-> {
                if (!b9Val.isEmpty() && (b9Val.equals(b3Val) && b9Val.equals(b6Val))
                    || (b9Val.equals(b1Val) && b9Val.equals(b5Val))
                    || (b9Val.equals(b7Val) && b9Val.equals(b8Val)))
                {
                    winner = true
                }
            }
            else-> {

                    winner = false
                }
            }

        return winner
    }
    fun nuevaPartida(view: View) {
        b1.text = ""
        b2.text = ""
        b3.text = ""
        b4.text = ""
        b5.text = ""
        b6.text = ""
        b7.text = ""
        b8.text = ""
        b9.text = ""
        gameFinished = false
        currentPlayer = if(currentPlayer == 1) 2 else 1
        currentPlayer = if(scorePlayer1 ==0 && scorePlayer2 == 0) 1 else currentPlayer
        tvPlayer1.setTextColor(if(currentPlayer == 1) Color.GREEN else Color.GRAY)
        tvPlayer2.setTextColor(if(currentPlayer == 2) Color.GREEN else Color.GRAY)
    }

}
