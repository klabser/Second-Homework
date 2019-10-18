package bonch.dev.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class MyFragment : Fragment(){
    private lateinit var textView:TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.my_fragment, container, false)

        textView = view.findViewById(R.id.textView)

        return view
    }
    fun setTextView(){
        var a = getArguments()!!.getString("argText", "");
        textView.setText(a)
    }
}