package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.text_view)


        val ind = intent.getBooleanExtra ("Indicator",false)
        val count = intent.getIntExtra ("Counts",0)
        val text = intent.getStringExtra ("Text")

        textView.text = "$ind\n$count\n$text"
    }
}