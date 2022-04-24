package com.example.shapesandcolors

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


var color : String = ""
var shape : String= ""
private lateinit var imgResult: ImageView
private lateinit var txtResult: TextView
var timer: CountDownTimer? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorRed = findViewById<ImageView>(R.id.color_red)
        val colorGreen = findViewById<ImageView>(R.id.color_green)
        val colorBlue = findViewById<ImageView>(R.id.color_blue)
        val colorYellow = findViewById<ImageView>(R.id.color_yellow)
        val shapeCircle = findViewById<ImageView>(R.id.shape_circle)
        val shapeTriangle = findViewById<ImageView>(R.id.shape_triangle)
        val shapeRectangle = findViewById<ImageView>(R.id.shape_rectangle)
        val shapeStar = findViewById<ImageView>(R.id.shape_star)
        txtResult = findViewById(R.id.txtResult)
        imgResult = findViewById(R.id.imgResult)

        colorBlue.setOnClickListener {
            color="blue"
            setResult()
        }

        colorGreen.setOnClickListener {
            color="green"
            setResult()
        }

        colorYellow.setOnClickListener {
            color="yellow"
            setResult()
        }
        colorRed.setOnClickListener {
            color="red"
            setResult()
        }

        shapeCircle.setOnClickListener {
            shape="circle"
            setResult()
        }

        shapeRectangle.setOnClickListener {
            shape="rectangle"
            setResult()
        }

        shapeStar.setOnClickListener {
            shape="star"
            setResult()
        }

        shapeTriangle.setOnClickListener {
            shape="triangle"
            setResult()
        }

    }

    private fun startTimer(timeLengthMilli: Long) {
        stopTimer()
        timer = object : CountDownTimer(timeLengthMilli, 1000) {
            override fun onTick(milliTillFinish: Long) {}
            override fun onFinish() {
                clearResult()
            }
        }
        (timer as CountDownTimer).start()
    }

    private fun setResult() {
        startTimer(300*1000) // 5 minutes = 300 seconds
        var imageName ="img_"+shape+"_"+color
        var drawable =  resources.getIdentifier(imageName, "drawable", packageName);
        imgResult.setImageResource(drawable);
        txtResult.text = "Color $color and Shape $shape selected. Result is"
    }

    private fun clearResult(){
        imgResult.setImageDrawable(null)
        txtResult.text = ""
        shape=""
        color=""
    }

    private fun stopTimer() {
        timer?.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopTimer()
    }

}