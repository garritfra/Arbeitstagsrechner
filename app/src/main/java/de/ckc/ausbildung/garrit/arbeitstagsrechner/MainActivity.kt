package de.ckc.ausbildung.garrit.arbeitstagsrechner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import de.ckc.ausbildung.garrit.arbeitstagsrechner.Utils.Constants
import de.ckc.ausbildung.garrit.arbeitstagsrechner.model.DateInterval
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var dateInterval: DateInterval

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateStartEditText = findViewById<EditText>(R.id.date_start_editText)
        val dateEndEditText = findViewById<EditText>(R.id.date_end_editText)
        val calculateIntervalButton = findViewById<Button>(R.id.calculate_interval_button)
        val dateIntervalTextView = findViewById<TextView>(R.id.date_interval_textView)

        calculateIntervalButton.setOnClickListener({
            val dateStart: Calendar = parseStringToCalendar(dateStartEditText.text.toString())
            val dateEnd: Calendar = parseStringToCalendar(dateEndEditText.text.toString())
            dateInterval = DateInterval(dateStart, dateEnd)
            val dateIntervalStr = dateInterval.intervalInDays.toString()
            val daysString: String = dateIntervalStr + " Days"
            updateTextView(dateIntervalTextView, daysString)

        })


    }

    private fun updateTextView(textView: TextView, value: String) {
        textView.text = value
    }

    private fun parseStringToCalendar(dateStr: String): Calendar {
        val format = SimpleDateFormat(Constants.datePattern, Locale.GERMAN)
        val date = format.parse(dateStr)
        val cal = Calendar.getInstance()
        cal.time = date
        return cal

    }

}
