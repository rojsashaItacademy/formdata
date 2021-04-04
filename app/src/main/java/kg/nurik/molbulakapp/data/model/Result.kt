package kg.nurik.molbulakapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    val code: Int,
    val id: String,
    val login: String,
    val message: String,
    val password: String
): Parcelable