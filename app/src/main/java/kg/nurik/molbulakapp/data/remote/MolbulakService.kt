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
    ): Response<BaseList<ResultCode>>

    @FormUrlEncoded
    @POST("api/app/checkCode")
    suspend fun checkCode(
        @FieldMap map: Map<String, Int>,
        @Query("token") token: String
    ): Response<BaseList<CheckCode>>

    @FormUrlEncoded
    @POST("api/app/registration")
    suspend fun registration(
        @Field("first_name") first_name: String,
        @Field("last_name") last_name: String,
        @Field("second_name") second_name: String,
        @Field("u_date") u_date: String,
        @Field("gender") gender: String,
        @Field("nationality") nationality: String,
        @Field("first_phone") first_phone: String,
        @Field("second_phone") second_phone: String,
        @Field("traffic_source") traffic_source: String,
        @Field("question") question: String,
        @Field("response") response: String,
        @Field("sms_code") sms_code: String,
        @Field("system") system: String,
        @Query("token") token: String
    ): Response<ListRegistration>
}
