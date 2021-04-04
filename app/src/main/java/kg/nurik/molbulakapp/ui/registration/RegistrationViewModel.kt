package kg.nurik.molbulakapp.ui.registration

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.molbulakapp.data.interactors.Interactors
import kg.nurik.molbulakapp.data.model.ListRegistration
import kg.nurik.molbulakapp.data.model.UserCreateModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationViewModel(private val network: Interactors) : ViewModel() {

    val register = MutableLiveData<ListRegistration>()

    fun verifyCredentialsRegister(data: UserCreateModel) {
        if (data.first_name.isNullOrEmpty() && data.last_name.isNullOrEmpty())
            register(data)
    }

    private fun register(data: UserCreateModel) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result = network.registration(data, token = "oYyxhIFgJjAb")
                if (result.isSuccessful)
                    register.postValue(result.body())
            }.onFailure {
                Log.d("Registration", it.localizedMessage ?: "error request")
            }
        }
    }

}