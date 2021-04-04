package kg.nurik.molbulakapp.data.local

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {

    private const val PREFERENCE_NAME = "molbulakapp"
    private var preference: SharedPreferences? = null
    private const val TOKEN = "TOKEN"

    fun initPreference(context: Context) {
        preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun setTokenPhoneNumber(id: Int) {
        preference?.edit()?.putString(TOKEN, id.toString())?.apply()
    }

    fun getTokenPhoneNumber() = preference?.getString(TOKEN, null)
}
