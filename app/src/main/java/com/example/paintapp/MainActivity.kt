package com.example.paintapp

import android.graphics.Color
import android.graphics.Color.RED
import android.graphics.Paint
import android.graphics.Path
import android.hardware.camera2.params.RggbChannelVector.RED
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import com.example.paintapp.PaintView.Companion.colorList
import com.example.paintapp.PaintView.Companion.currentBrush
import com.example.paintapp.PaintView.Companion.pathList
import com.example.paintapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
         var path = Path()
         var paintBrush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redBtn=findViewById<ImageButton>(R.id.red)
        val blueBtn=findViewById<ImageButton>(R.id.blue)
        val blackBtn=findViewById<ImageButton>(R.id.black)
        val eraser=findViewById<ImageButton>(R.id.white)

        redBtn.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.RED
            currentColor(paintBrush.color)
        }

        blueBtn.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.BLUE)
            currentColor(paintBrush.color)
        }

        blackBtn.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            paintBrush.setColor(Color.BLACK)
            currentColor(paintBrush.color)
        }

        eraser.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
            pathList.clear()
            colorList.clear()
            path.reset()
        }
    }
    private fun currentColor(color: Int){
        currentBrush = color
        path = Path()
    }
}