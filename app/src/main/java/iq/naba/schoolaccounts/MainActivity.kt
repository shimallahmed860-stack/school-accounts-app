package iq.naba.schoolaccounts

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(40, 50, 40, 40)
        }

        val title = TextView(this).apply {
            text = "حسابات المدرسة"
            textSize = 28f
            gravity = android.view.Gravity.CENTER
        }

        val studentName = EditText(this).apply {
            hint = "اسم الطالب"
        }

        val studentClass = EditText(this).apply {
            hint = "الصف"
        }

        val totalAmount = EditText(this).apply {
            hint = "القسط الكلي"
            inputType = android.text.InputType.TYPE_CLASS_NUMBER
        }

        val paidAmount = EditText(this).apply {
            hint = "المبلغ الواصل"
            inputType = android.text.InputType.TYPE_CLASS_NUMBER
        }

        val result = TextView(this).apply {
            textSize = 20f
            gravity = android.view.Gravity.CENTER
        }

        val calculateButton = Button(this).apply {
            text = "حساب الباقي"

            setOnClickListener {
                val total = totalAmount.text.toString().toLongOrNull() ?: 0
                val paid = paidAmount.text.toString().toLongOrNull() ?: 0
                val remaining = total - paid

                result.text = "المبلغ الباقي: $remaining"
            }
        }

        layout.addView(title)
        layout.addView(studentName)
        layout.addView(studentClass)
        layout.addView(totalAmount)
        layout.addView(paidAmount)
        layout.addView(calculateButton)
        layout.addView(result)

        setContentView(layout)
    }
}
