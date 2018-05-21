package de.ckc.ausbildung.garrit.arbeitstagsrechner.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import de.ckc.ausbildung.garrit.arbeitstagsrechner.R
import java.io.File

class SaveDateIntervalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_date_interval)

        val saveIntervalButton = findViewById<Button>(R.id.save_interval_button)
        val fileNameEditText = findViewById<EditText>(R.id.file_name_edittext)

        saveIntervalButton.setOnClickListener({
            val fileName = extractStringFromEditText(fileNameEditText)
            val file = File(this.filesDir, fileName)
            file.appendText("Hello World\n")
        })
    }

    private fun extractStringFromEditText(editText: EditText): String {
        return editText.text.toString()
    }
}
