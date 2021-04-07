package kg.nurik.molbulakapp.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import java.util.regex.Pattern

class PasswordEditText : AppCompatEditText {

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

        checkPassword()

        return true
    }

    private fun checkPassword(): Boolean {
        val pattern = Pattern.compile(PATTERN)
        val text = this.text.toString()
        val result = pattern.matcher(text).matches()
        if (!result)
            showPatternError()
        return result
    }

    private fun showErrorEmptyText() {
        this.error = "Пароль должен содержать не менее 8 символов"
    }

    private fun showPatternError() {
        this.error = "Пароль должен содержать только цифры"
    }

    private fun showsRepeatPasswordTheSameError() {
        this.error = "Пароли должны совпадать"
    }

    fun isRepeatPasswordTheSame(text: String): Boolean {
        val result = text == this.text.toString().trim()
        if (!result)
            showsRepeatPasswordTheSameError()
        return result
    }

    private fun validateIsEmpty(): Boolean {
        val isEmpty = this.text.toString().isEmpty()
        if (isEmpty)
            showErrorEmptyText()


        return isEmpty
    }

    companion object {
        private const val PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,10}"
    }

}