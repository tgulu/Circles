package com.example.circle

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.view.View

import android.transition.TransitionManager
import com.example.circle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Variable to store the selected count
    private var selectedCircleCount = 0
    private var currentViewState = ""

    // Variable to store the current view
    private var currentView: View? = null

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun createCircleView(context: Context, selectedCount: Int): View {
            val circleView = CircleView(context, selectedCount)
            binding.mainLayout.addView(circleView)
            return circleView
        }

        fun createLineView(context: Context, selectedCount: Int): View {
            val lineView = LineView(context, selectedCount)
            binding.mainLayout.addView(lineView)
            return lineView
        }

        binding.tenCircleButton.setOnClickListener {
            selectedCircleCount = 10
            currentView = if (currentViewState == "circle") {
                createCircleView(this, selectedCircleCount)
            } else {
                createLineView(this, selectedCircleCount)
            }
            binding.mainLayout.visibility = View.VISIBLE
        }

        binding.sevenCircleButton.setOnClickListener {
            selectedCircleCount = 7
            currentView = if (currentViewState == "circle") {
                createCircleView(this, selectedCircleCount)
            } else {
                createLineView(this, selectedCircleCount)
            }
            binding.mainLayout.visibility = View.VISIBLE
        }

        binding.fiveCircleButton.setOnClickListener {
            selectedCircleCount = 5
            currentView = if (currentViewState == "circle") {
                createCircleView(this, selectedCircleCount)
            } else {
                createLineView(this, selectedCircleCount)
            }
            binding.mainLayout.visibility = View.VISIBLE
        }

        //transition for circle to line view
        val viewTransition = ChangeBounds()
        viewTransition.duration = 300

        binding.lineButton.setOnClickListener {

            currentViewState = "line"
            binding.sevenCircleButton.visibility = View.VISIBLE
            binding.fiveCircleButton.visibility = View.VISIBLE
            binding.tenCircleButton.visibility = View.VISIBLE

            TransitionManager.beginDelayedTransition(binding.mainLayout, viewTransition)
            currentView = when (selectedCircleCount) {
                5 -> createLineView(this, 5)
                7 -> createLineView(this, 7)
                10 -> createLineView(this, 10)
                else -> {
                    createLineView(this, 10)
                }
            }
        }

        binding.circleButton.setOnClickListener {

            currentViewState = "circle"
            binding.sevenCircleButton.visibility = View.VISIBLE
            binding.fiveCircleButton.visibility = View.VISIBLE
            binding.tenCircleButton.visibility = View.VISIBLE

            TransitionManager.beginDelayedTransition(binding.mainLayout, viewTransition)
            currentView = when (selectedCircleCount) {
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









