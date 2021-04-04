package kg.nurik.molbulakapp.data.remote

import kg.nurik.molbulakapp.data.model.BaseList
import kg.nurik.molbulakapp.data.model.CheckCode
import kg.nurik.molbulakapp.data.model.ResultCode
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface MolbulakService {

    @POST("api/app/checkPhone")
    suspend fun checkPhone(
        @Body data: String,
        @Query("token") token: String
    ): Response<BaseList>


    @POST("api/app/checkCode")
    suspend fun checkCode(
        @Body data: Map<Int, Int>,
        @Query("token") token: String
    ): Response<CheckCode>
}
