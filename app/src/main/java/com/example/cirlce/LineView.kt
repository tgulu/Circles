package com.example.cirlce

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class LineView(context: Context, var count: Int) : View(context) {
    private val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 3f

    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        for (i in 0 until count) {
            val circleRadius = 40f
            val circleX = (width / (count + 1) * (i + 1)).toFloat()
            val circleY = height / 2f
            canvas?.drawCircle(circleX, circleY, circleRadius, paint)
        }
    }
}