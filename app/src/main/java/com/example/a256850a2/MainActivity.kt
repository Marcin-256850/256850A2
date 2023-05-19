package com.example.a256850a2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    var radioGroup: RadioGroup? = null
    lateinit var kwota: EditText
    lateinit var napiwek: TextView
    lateinit var gwiazda: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener{oblicz()}
        title = "Kalkulator napiwsku"
        radioGroup = findViewById(R.id.radioGroup)
    }
    fun oblicz(){
        kwota = findViewById(R.id.editText)
        napiwek = findViewById(R.id.textView4)
        val zaok = findViewById<Switch>(R.id.switch1).isChecked
        val num1 = kwota.text.toString().toDouble()
        val selectedOption: Int = radioGroup!!.checkedRadioButtonId
        val procent = when (selectedOption) {
            R.id.radioButton -> 0.05
            R.id.radioButton2 -> 0.10
            else -> 0.15
        }
        val w = num1*procent
        var wynik:Double = String.format("%.2f", w).toDouble()
        if (zaok){
            wynik = kotlin.math.ceil(wynik)
        }
        val rBar = findViewById<RatingBar>(R.id.ratingBar)
        gwiazda = findViewById(R.id.textView5)
        val msg = rBar.rating.toString()
        gwiazda.text = msg
        napiwek.text = wynik.toString()

    }
}