package de.ckc.ausbildung.garrit.arbeitstagsrechner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateStart = findViewById<EditText>(R.id.date_start_editText)
        val dateEnd = findViewById<EditText>(R.id.date_end_editText)



    }
}
