package br.com.fiap.pingpongandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_placar.*

class PlacarActivity : AppCompatActivity() {

    var scorePlayer1 = 0
    var scorePlayer2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placar)

        if (savedInstanceState != null) {
           scorePlayer1 = savedInstanceState.getInt("SCORE_PLAYER_1", 0)
           scorePlayer2 = savedInstanceState.getInt("SCORE_PLAYER_2", 0)
        }

        setUpExtras()
        startGame()

        btPontoP1.setOnClickListener {
            scorePlayer1++
            tvPlacarP1.text = scorePlayer1.toString()
        }

        btPontoP2.setOnClickListener {
            scorePlayer2++
            tvPlacarP2.text = scorePlayer2.toString()
        }

        ivVoltarPlayer.setOnClickListener {
            val intent = Intent(this, PlayerActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("SCORE_PLAYER_1", scorePlayer1)
        outState?.putInt("SCORE_PLAYER_2", scorePlayer2)
    }

    private fun startGame() {
        tvPlacarP1.text = scorePlayer1.toString()
        tvPlacarP2.text = scorePlayer2.toString()
    }

    private fun setUpExtras() {
        tvNomeP1.text = intent.getStringExtra("PLAYER_1")
        tvNomeP2.text = intent.getStringExtra("PLAYER_2")
    }


}
