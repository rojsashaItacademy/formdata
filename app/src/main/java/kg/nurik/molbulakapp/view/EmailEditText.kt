package kg.nurik.molbulakapp.view

import android.content.Context
import android.util.AttributeSet
import android.util.Patterns
import androidx.appcompat.widget.AppCompatEditText
import java.util.regex.Pattern

class EmailEditText: AppCompatEditText {


    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun validate(): Boolean {
        if (validateIsEmpty())
            return false

        checkEmail()

        return true
    }

    private fun validateIsEmpty(): Boolean {
        val isEmpty = this.text.toString().isEmpty()
        if (isEmpty)
            showErrorEmptyText()


        return isEmpty
    }

    private fun checkEmail(): Boolean {
        val text = this.text.toString()
        val result = Patterns.EMAIL_ADDRESS.matcher(text).matches()
        if (!result)
            showPatternError()
        return result
    }

    private fun showPatternError() {
        this.error = "Неправильный email"
    }

    private fun showErrorEmptyText() {
        this.error = "Введите почту"
    }

}