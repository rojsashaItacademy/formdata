package kg.nurik.molbulakapp.data.model

data class UserCreateModel(
    var last_name: String = "",
    var first_name: String = "",
    var second_name: String = "",
    var u_date: String = "DAYMONTH",
    var gender: Int = 1,
    var nationality: Int = 2,
    var first_phone: Long = 996508170177,
    var second_phone: Long = 996508170178,
    var traffic_source: Int = 1,
    var question: Int = 1,
    var response: String = "",
    var sms_code: Int = 312,
    var system: Int = 1
)