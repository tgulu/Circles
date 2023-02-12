package com.example.cirlce
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    // Variable to store the selected count
    private var selectedCount = 0

    // Variable to store the current view
    private var currentView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainLayout by lazy {
            RelativeLayout(this).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        }

        fun createCircleView(context: Context, selectedCount: Int): View {
            val circleView = CircleView(context, selectedCount)
            mainLayout.addView(circleView)
            return circleView
        }

        fun createLineView(context: Context, selectedCount: Int): View {
            val lineView = LineView(context, selectedCount)
            mainLayout.addView(lineView)
            return lineView
        }

        val tenCircleButton = Button(this)
        tenCircleButton.id = R.id.ten_circle_button
        tenCircleButton.text = "10"
        val tenCircleParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT)
        tenCircleParams.addRule(RelativeLayout.ALIGN_PARENT_TOP)
        tenCircleParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        tenCircleButton.layoutParams = tenCircleParams
        mainLayout.addView(tenCircleButton)

        val sevenCircleButton = Button(this)
        sevenCircleButton.id = R.id.seven_circle_button
        sevenCircleButton.text = "7"
        val sevenCircleParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT)
        sevenCircleParams.addRule(RelativeLayout.CENTER_HORIZONTAL)
        sevenCircleButton.layoutParams = sevenCircleParams
        mainLayout.addView(sevenCircleButton)

        val fiveCircleButton = Button(this)
        fiveCircleButton.id = R.id.five_circle_button
        fiveCircleButton.text = "5"
        val fiveCircleParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT)
        fiveCircleParams.addRule(RelativeLayout.ALIGN_PARENT_TOP)
        fiveCircleParams.addRule((RelativeLayout.ALIGN_PARENT_LEFT))
        fiveCircleButton.layoutParams = fiveCircleParams
        mainLayout.addView(fiveCircleButton)

        val lineButton = Button(this)
        lineButton.id = R.id.line_button
        lineButton.text = "Line"
        val lineParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT)
        lineParams.addRule(RelativeLayout.BELOW, fiveCircleButton.id)
        lineParams.addRule(RelativeLayout.ALIGN_PARENT_START)
        lineButton.layoutParams = lineParams
        mainLayout.addView(lineButton)

        val circleButton = Button(this)
        circleButton.id = R.id.circle_button
        circleButton.text = "Circle"
        val circleParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT)
        circleParams.addRule(RelativeLayout.BELOW, tenCircleButton.id)
        circleParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        circleButton.layoutParams = circleParams
        mainLayout.addView(circleButton)

        setContentView(mainLayout)
        mainLayout.invalidate()

        tenCircleButton.setOnClickListener {
            selectedCount = 10
            currentView = createCircleView(this, selectedCount)
            currentView = createLineView(this, selectedCount)
        }

        sevenCircleButton.setOnClickListener {
            selectedCount = 7
            currentView = createCircleView(this, selectedCount)
            currentView = createLineView(this, selectedCount)
        }

        fiveCircleButton.setOnClickListener {
            selectedCount = 5
            currentView = createCircleView(this, selectedCount)
            currentView = createLineView(this, selectedCount)
        }

        lineButton.setOnClickListener {
            currentView = when (selectedCount) {
                5 -> createLineView(this, 5)
                7 -> createLineView(this, 7)
                10 -> createLineView(this, 10)
                else -> {
                    createLineView(this, 10)

                }
            }
        }

        circleButton.setOnClickListener {
            currentView = when (selectedCount) {
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