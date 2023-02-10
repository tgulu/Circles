package com.example.cirlce
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    var selectedCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun createCircleView(context: Context, circleCount: Int) {
            val circleView = CircleView(context, circleCount)
            setContentView(circleView)
            circleView.invalidate()
        }
        fun createLineView(context: Context, lineCount: Int) {
            val lineView = LineView(context, lineCount)
            setContentView(lineView)
            lineView.invalidate()
        }

        val tenCircleButton = findViewById<Button>(R.id.ten_circle_button)
        tenCircleButton.setOnClickListener {
            selectedCount = 10
            createCircleView(this, selectedCount)
            createLineView(this, selectedCount)
        }

        val sevenCircleButton = findViewById<Button>(R.id.seven_circle_button)
        sevenCircleButton.setOnClickListener {
            selectedCount = 7
            createCircleView(this, selectedCount)
            createLineView(this, selectedCount)
        }


        val fiveCircleButton = findViewById<Button>(R.id.five_circle_button)
        fiveCircleButton.setOnClickListener {
            selectedCount = 5
            createCircleView(this, selectedCount)
            createLineView(this, selectedCount)
        }

        val lineButton = findViewById<Button>(R.id.line_button)
        lineButton.setOnClickListener {
            when (selectedCount) {
                5 -> createLineView(this, 5)
                7 -> createLineView(this, 7)
                10 -> createLineView(this, 10)
                else -> {
                    createLineView(this, 10)

                }
            }
        }

            val circleButton = findViewById<Button>(R.id.circle_button)
            circleButton.setOnClickListener {
                when (selectedCount) {
                    5 -> createCircleView(this, 5)
                    7 -> createCircleView(this, 7)
                    10 -> createCircleView(this, 10)
                    else -> {
                        createCircleView(this, 10)

                    }
                }
            }


        }
    }













