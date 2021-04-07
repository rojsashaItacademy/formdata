package kg.nurik.molbulakapp.data.interactors

import kg.nurik.molbulakapp.data.model.*
import kg.nurik.molbulakapp.data.remote.MolbulakService
import retrofit2.Response

interface Interactors {
    suspend fun checkNumber(phone: String, token: String): Response<BaseList<ResultCode>>
    suspend fun checkCode(id: Int = 200, code: Int, token: String): Response<BaseList<CheckCode>>
    suspend fun registration(data: UserCreateModel, token: String): Response<ListRegistration>
}

class InteractorsImpl(private val service: MolbulakService) : Interactors {

    override suspend fun checkNumber(phone: String, token: String): Response<BaseList<ResultCode>> {
        return service.checkPhone(phone, token = token)
    }

    override suspend fun checkCode(
        id: Int,
        code: Int,
        token: String
    ): Response<BaseList<CheckCode>> {
        val map = mapOf(
            "id" to id,
            "code" to code
        )

        return service.checkCode(map = map, token = token)
    }

    override suspend fun registration(
        data: UserCreateModel,
        token: String
    ): Response<ListRegistration> {
        return service.registration(
            last_name = data.last_name,
            first_name = data.first_name,
            second_name = data.second_name,
            u_date = data.u_date,
            gender = data.gender.toString(),
            nationality = data.nationality.toString(),
            first_phone = data.first_phone.toString(),
            second_phone = data.second_phone.toString(),
            traffic_source = data.traffic_source.toString(),
            question = data.question.toString(),
            response = data.response,
            sms_code = data.sms_code.toString(),
            system = data.system.toString(),
            token = token
        )
    }

}