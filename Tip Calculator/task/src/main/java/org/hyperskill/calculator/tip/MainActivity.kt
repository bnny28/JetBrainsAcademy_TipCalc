package org.hyperskill.calculator.tip

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                setTextView(edit_text.text, slider.value)
            }
        })

//        slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
//            override fun onStartTrackingTouch(slider: Slider) {}
//
//            override fun onStopTrackingTouch(slider: Slider) {
//                setTextView(edit_text.text, slider.value)
//            }
//        })

        slider.addOnChangeListener { _, value, _ ->
            setTextView(edit_text.text, value)
        }
    }

    @SuppressLint("SetTextI18n")
    fun setTextView(x: Editable, p: Float) {
        if (x.isNotEmpty())
            text_view.text =
                "Tip amount: %.2f".format(x.toString().toFloat() * p / 100)
    }
}