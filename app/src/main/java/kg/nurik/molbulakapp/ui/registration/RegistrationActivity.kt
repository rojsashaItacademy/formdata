package kg.nurik.molbulakapp.ui.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kg.nurik.molbulakapp.R
import kg.nurik.molbulakapp.data.model.UserCreateModel
import kg.nurik.molbulakapp.databinding.ActivityAuthorizationBinding
import kg.nurik.molbulakapp.databinding.ActivityRegistrationBinding
import kg.nurik.molbulakapp.ui.authorization.AuthorizationViewModel
import kg.nurik.molbulakapp.ui.dialog.CodeViewModel
import kg.nurik.molbulakapp.view.viewBinding
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityRegistrationBinding::inflate)
    private val vm by viewModel<RegistrationViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnRegistration.setOnClickListener {
            if (validateAll())
                vm.register(UserCreateModel())
        }
    }

    private fun validateAll(): Boolean {
        binding.etPassword.validate()
        binding.etRepeatPassword.isRepeatPasswordTheSame(binding.etPassword.text.toString())

        return true
    }

}