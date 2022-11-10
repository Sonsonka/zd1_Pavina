package com.example.zd1_pavina

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import java.text.ParsePosition

class MainActivity2 : AppCompatActivity() {
    lateinit var user: TextView
    lateinit var film: TextView
    private var titleFilm = arrayListOf<String>("Гордость и предубеждение", "Искупление", "Маленькие женщины", "Энола Холмс", "С любовью, Рози")
    lateinit var moveselection: Spinner
    private var SelectedFilms: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        user=findViewById(R.id.user)

        var pref = this.getSharedPreferences(APP_PREFERENCES_LOG, MODE_PRIVATE)
        user.text = pref.toString()
        moveselection.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                itemSeleted : View,
                selectedPosition: Int,
                SelectedId : Long
            ) {
               SelectedFilms = titleFilm[selectedPosition]
                var toast = Toast.makeText(applicationContext, "${SelectedFilms}", Toast.LENGTH_SHORT)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}