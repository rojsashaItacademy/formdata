package kg.nurik.molbulakapp.data.remote

import kg.nurik.molbulakapp.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface MolbulakService {

    @FormUrlEncoded
    @POST("api/app/checkPhone")
    suspend fun checkPhone(
        @Field("phone") data: String,
        @Query("token") token: String
    ): Response<BaseList>

    @POST("api/app/checkCode")
    suspend fun checkCode(
        @Body data: Map<Int, Int>,
        @Query("token") token: String
    ): Response<CheckCode>

    @POST("api/app/registration")
    suspend fun registration(
        @Body data: UserCreateModel,
        @Query("token") token: String
    ): Response<ListRegistration>

}
