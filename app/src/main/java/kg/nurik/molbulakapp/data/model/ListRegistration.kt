package kg.nurik.molbulakapp.data.model

data class ListRegistration(
    val code: Int,
    val result: Result,
    val error: Error
)

data class Error(
    val code:Int,
    val message: String
)