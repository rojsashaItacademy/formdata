package kg.nurik.molbulakapp.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kg.nurik.molbulakapp.R

class VerifyCheckCodeDialog(
    context: Context,
    private val listener: DialogCLicks
) : Dialog(context) {

    private var btnProceed: Button? = null
    private var etCode: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_sms_registration)
        setCancelable(false)
        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        btnProceed = findViewById(R.id.btnProceed)
        etCode = findViewById(R.id.etCode)
    }

    private fun setupListeners() {
        btnProceed?.setOnClickListener {
            if (etCode != null) {
                listener.sendText(etCode?.text.toString().toInt())
                dismiss()
            } else {
                Toast.makeText(context, "Ведите код из смс", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

interface DialogCLicks {
    fun clickDialog(isNeedCloseApp: Boolean)
    fun sendText(code: Int)
}