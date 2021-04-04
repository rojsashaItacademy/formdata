package kg.nurik.molbulakapp.data.model

data class UserCreateModel(
    var phoneNumber: String = "",
    var first_name: String = "",
    var last_name: String = "",
    var password: String = "",
    var school_id: String = "",
    var role_code: String = "",
    var gender: String = "",
    var birthdate: String = "",
    var token: String? = ""
)