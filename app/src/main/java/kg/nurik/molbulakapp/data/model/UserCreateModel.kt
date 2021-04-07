package kg.nurik.molbulakapp.data.model

data class UserCreateModel(
    var last_name: String = "timur66",
    var first_name: String = "imankulov66",
    var second_name: String = "serecovich",
    var u_date: String = "12.12.2000",
    var gender: Int = 1,
    var nationality: Int = 1,
    var first_phone: Long = 996555444366,
    var second_phone: Long = 996555444366,
    var traffic_source: Int = 17,
    var question: Int = 1,
    var response: String = "sasha",
    var sms_code: Int = 312,
    var system: Int = 1
)