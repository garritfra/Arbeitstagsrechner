package de.ckc.ausbildung.garrit.arbeitstagsrechner.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import de.ckc.ausbildung.garrit.arbeitstagsrechner.R
import de.ckc.ausbildung.garrit.arbeitstagsrechner.Utils.DateParser
import de.ckc.ausbildung.garrit.arbeitstagsrechner.model.DateInterval
import java.text.ParseException
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var dateInterval: DateInterval

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateIntervalButton = findViewById<Button>(R.id.calculate_interval_button)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floating_action_button)

        floatingActionButton.setOnClickListener((View.OnClickListener {
            handleFloatingActionButtonClicked()
        }))

        calculateIntervalButton.setOnClickListener({
            handleCalculateIntervalButtonClicked()
        })

    }

    private fun handleFloatingActionButtonClicked() {
        val saveDateIntervalActivityIntent = Intent(this, SaveDateIntervalActivity::class
                .java)
        startActivity(saveDateIntervalActivityIntent)
    }

    private fun handleCalculateIntervalButtonClicked() {

        val dateStartEditText = findViewById<EditText>(R.id.date_start_editText)
        val dateEndEditText = findViewById<EditText>(R.id.date_end_editText)
        val dateIntervalTextView = findViewById<TextView>(R.id.date_interval_textView)
        val dateStart: Calendar = handleDateInput(dateStartEditText)
        val dateEnd: Calendar = handleDateInput(dateEndEditText)

        dateInterval = DateInterval(dateStart, dateEnd)
        val daysString = generateDaysString(dateInterval)

        if (dateInterval.isValid) {
            updateTextView(dateIntervalTextView, daysString)
        } else {
            dateEndEditText.error = "End date should not be before start date"
        }
    }

    private fun generateDaysString(dateInterval: DateInterval): String {
        val dateIntervalStr = dateInterval.intervalInDays.toString()
        return "$dateIntervalStr Days"
    }

    private fun handleDateInput(dateEditText: EditText): Calendar {
        var valid = true
        var date: Calendar = Calendar.getInstance()

        while (valid) {

            valid = false

            try {
                date = DateParser.parseStringToCalendar(dateEditText.text
                        .toString())
            } catch (e: ParseException) {
                valid = false
                dateEditText.error = "Enter a valid date!"
            }

        }
        return date
    }

    private fun updateTextView(textView: TextView, value: String) {
        textView.text = value
    }

}
