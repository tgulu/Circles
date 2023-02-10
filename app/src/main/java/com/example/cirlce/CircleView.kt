package com.example.cirlce

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class CircleView(context: Context, var count: Int) : View(context) {
    private val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 3f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val width = width
        val height = height
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = Math.min(width, height) / 2f - 50f

        for (i in 0 until count) {
            val angle = 360f / count * i
            val x = centerX + radius * Math.cos(Math.toRadians(angle.toDouble())).toFloat()
            val y = centerY + radius * Math.sin(Math.toRadians(angle.toDouble())).toFloat()
            canvas?.drawCircle(x, y, 40f, paint)
        }
    }
}