package com.example.sampleapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var clicks = 0
    private var clickPower = 1
    private var upgradeCost = 10
    private lateinit var scoreText: TextView
    private lateinit var upgradeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreText = findViewById(R.id.scoreText)
        upgradeButton = findViewById(R.id.upgradeButton)
        val clickButton = findViewById<Button>(R.id.clickButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        updateUI()

        clickButton.setOnClickListener {
            clicks += clickPower
            updateUI()
        }

        upgradeButton.setOnClickListener {
            if (clicks >= upgradeCost) {
                clicks -= upgradeCost
                clickPower += 1
                upgradeCost = (upgradeCost * 1.5).toInt()
                updateUI()
            }
        }

        resetButton.setOnClickListener {
            clicks = 0
            clickPower = 1
            upgradeCost = 10
            updateUI()
        }
    }

    private fun updateUI() {
        scoreText.text = "Кликов: $clicks\nСила клика: $clickPower"
        upgradeButton.text = "Улучшение ($upgradeCost)"
        upgradeButton.isEnabled = clicks >= upgradeCost
    }
}
