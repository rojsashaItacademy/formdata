package kg.nurik.molbulakapp.ui.authorization

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.molbulakapp.data.interactors.Interactors
import kg.nurik.molbulakapp.data.local.PreferenceHelper
import kg.nurik.molbulakapp.data.model.BaseList
import kg.nurik.molbulakapp.data.model.ResultCode
import kg.nurik.molbulakapp.view.toSingleEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthorizationViewModel(private val network: Interactors) : ViewModel() {

    val data = MutableLiveData<BaseList>()
    val eventPhoneError = MutableLiveData<Boolean>().toSingleEvent()

    fun verifyCredentials(phone: String) {
        if (checkPhoneErrorMessage(phone) && phone.length > 5)
            checkPhoneNumber(phone)
    }

    private fun checkPhoneNumber(phone: String) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result = network.checkNumber(phone, token = "oYyxhIFgJjAb")
                if (result.isSuccessful)
                    data.postValue(let { result.body() })

                result.body()?.result?.id?.let { PreferenceHelper.setTokenPhoneNumber(it) }
            }.onFailure {
                Log.d("CheckNumber", it.localizedMessage ?: "error request")
                eventPhoneError.postValue(true)
            }
        }
    }

    private fun checkPhoneErrorMessage(phone: String): Boolean {
        return Patterns.PHONE.matcher(phone.trim()).matches()
    }
}

