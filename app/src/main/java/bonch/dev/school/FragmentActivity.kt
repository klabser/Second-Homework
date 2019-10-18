package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import bonch.dev.school.fragments.FirstFragment
import bonch.dev.school.fragments.SecondFragment

class FragmentActivity : AppCompatActivity() {

    val fm = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        fm.beginTransaction()
            .add(R.id.fragment, FirstFragment())
            .commit()
    }

    fun replaceFragment(view: View) {
        fm.beginTransaction()
            .add(R.id.fragment, SecondFragment())
            .addToBackStack("thirdFragment")
            .commit()
    }
}
