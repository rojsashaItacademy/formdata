package kg.nurik.molbulakapp.data.interactors

import kg.nurik.molbulakapp.data.model.*
import kg.nurik.molbulakapp.data.remote.MolbulakService
import retrofit2.Response

interface Interactors {
    suspend fun checkNumber(phone: String, token: String): Response<BaseList>
    suspend fun checkCode(id: Int, code: Int, token: String): Response<CheckCode>
    suspend fun registration(data: UserCreateModel, token: String): Response<ListRegistration>
}

class InteractorsImpl(private val service: MolbulakService) : Interactors {

    override suspend fun checkNumber(phone: String, token: String): Response<BaseList> {
        return service.checkPhone(phone, token = token)
    }

    override suspend fun checkCode(id: Int, code: Int, token: String): Response<CheckCode> {
        val map = mapOf(
            312 to id,
            200 to code
        )
        return service.checkCode(map, token = token)
    }

    override suspend fun registration(
        data: UserCreateModel,
        token: String
    ): Response<ListRegistration> {
        return service.registration(data, token)
    }

}