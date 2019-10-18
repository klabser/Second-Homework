package bonch.dev.school


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class FragmentActivity : AppCompatActivity() {

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var textField: TextView
    private lateinit var attachFragmentButton: Button
    val fragment = MyFragment()

    val fragmentManager = supportFragmentManager

    private var indBool = false
    private var currentCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        initialization()
        setOnClickListener()

        if (savedInstanceState != null)
            reWrite(savedInstanceState)
    }

    private fun initialization() {
        indicatorButton = findViewById<Button>(R.id.indicator_button)
        counterButton = findViewById<Button>(R.id.counter_button)
        textField = findViewById<TextView>(R.id.text_field)
        attachFragmentButton = findViewById<Button>(R.id.attach_fragment_button)

        fragmentManager.beginTransaction().add(R.id.fragment, fragment)
            .commit()
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
        attachFragmentButton.setOnClickListener {
            val args = Bundle()
            var s = "$indBool\n$currentCount\n${textField.text.toString()}"
            args.putString("argText", s)
            fragment.arguments = args

            fragment.setTextView()
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