package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class FirstActivity : AppCompatActivity() {

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var textField: TextView
    private lateinit var nextActivityButton: Button

    private var indBool = false
    private var currentCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        init()
        setOnClickListener()

        if (savedInstanceState != null)

            reWrite(savedInstanceState)
    }

    private fun init() {
        indicatorButton = findViewById(R.id.indicator_button)
        counterButton = findViewById(R.id.counter_button)
        textField = findViewById(R.id.text_field)
        nextActivityButton = findViewById(R.id.next_activity_button)
    }

    private fun setOnClickListener() {
        indicatorButton.setOnClickListener {
            indicatorButton.isEnabled = false
            indBool = true
        }
        counterButton.setOnClickListener {
            currentCount++
            counterButton.text = currentCount.toString()
        }
        nextActivityButton.setOnClickListener {
            val intent = Intent(this@FirstActivity, SecondActivity::class.java)

            intent.putExtra("Indicator", indBool)
            intent.putExtra("Counts", currentCount)
            intent.putExtra("Text", textField.text.toString())

            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBoolean("Indicator", indBool)
        outState.putInt("Counts", currentCount)
        outState.putString("Text", textField.text.toString())
    }

    fun reWrite(savedInstanceState: Bundle) {
        indBool = savedInstanceState.getBoolean("Indicator")
        if (indBool) indicatorButton.isEnabled = false

        currentCount = savedInstanceState.getInt("Counts")
        counterButton.text = currentCount.toString()

        textField.text = savedInstanceState.getString("Text")
    }
}
