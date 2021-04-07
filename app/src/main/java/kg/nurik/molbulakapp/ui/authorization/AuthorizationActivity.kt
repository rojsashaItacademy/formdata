package kg.nurik.molbulakapp.ui.authorization

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kg.nurik.molbulakapp.R
import kg.nurik.molbulakapp.databinding.ActivityAuthorizationBinding
import kg.nurik.molbulakapp.ui.dialog.DialogCLicks
import kg.nurik.molbulakapp.ui.dialog.VerifyCheckCodeDialog
import kg.nurik.molbulakapp.ui.registration.RegistrationActivity
import kg.nurik.molbulakapp.view.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthorizationActivity : AppCompatActivity(), DialogCLicks {

    private val binding by viewBinding(ActivityAuthorizationBinding::inflate)
    private val vm by viewModel<AuthorizationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupVM()
        setDebugUserName()
        setupListeners()
    }

    private fun setupVM() {
        vm.eventPhoneError.observe(this, {
            Toast.makeText(this, "Не верный номер", Toast.LENGTH_LONG).show()
        })
        vm.eventCodeSuccess.observe(this, {
            openRegistActivity()
        })
    }

    private fun setDebugUserName() {
        binding.etPhoneNumber.setText(getString(R.string.phoneNumber))
    }

    private fun setupListeners() {
        binding.btnRegistration.setOnClickListener {
            sendETDataToVM()
            VerifyCheckCodeDialog(this, this).show()
        }
    }

    private fun sendETDataToVM() {
        vm.verifyCredentials(
            binding.etPhoneNumber.text.toString()
        )
    }

    override fun clickDialog(isNeedCloseApp: Boolean) {
        if (isNeedCloseApp) finish()
    }

    override fun sendText(code: Int) {
        vm.checkCode(code)

    }

    fun openRegistActivity(){
        startActivity(Intent(this,RegistrationActivity::class.java))
    }
}