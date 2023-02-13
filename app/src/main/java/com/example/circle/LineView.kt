package com.example.circle
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

// Custom view class that draws circles in a perpendicular line
class LineView(context: Context, var count: Int) : View(context) {
    private val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 3f

    }
    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)

        // Clear the canvas of any previous drawings
        canvas?.drawColor(Color.WHITE)

        //Calculate circles co-ordinates for the perpendicular line
        for (i in 0 until count) {
            val circleRadius = 60f
            val circleX = (width / (count + 1) * (i + 1)).toFloat()
            val circleY = height / 3.5f
            canvas?.drawCircle(circleX, circleY, circleRadius, paint)
        }
    }
}