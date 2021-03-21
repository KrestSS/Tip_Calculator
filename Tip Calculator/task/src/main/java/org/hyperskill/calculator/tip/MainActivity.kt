package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.edit_text)
        val slider: Slider = findViewById(R.id.slider)
        var billValue: CharSequence? = null
        var sliderValue: Int = slider.value.toInt()
        var text: CharSequence?

        editText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                billValue = if (s.isNullOrBlank()) null else edit_text.text
                text = if (billValue.isNullOrEmpty()) null else {
                    "Tip amount: ${"%.2f"
                            .format(billValue.toString().toDouble() * sliderValue / 100)}"
                }
                text_view.text = text
            }

            override fun afterTextChanged(s: Editable?) {}
        })


        slider.addOnChangeListener(Slider.OnChangeListener { _, value, _ ->
            sliderValue = value.toInt()
            text = if (billValue.isNullOrEmpty()) null else {
                "Tip amount: ${"%.2f"
                        .format(billValue.toString().toDouble() * sliderValue / 100)}"
            }
            text_view.text = text
        })
    }
}