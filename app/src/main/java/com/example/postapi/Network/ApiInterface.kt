package com.example.postapi.Network


import com.example.myapi.Response.ResponseData
import com.example.postapi.model.ModelBgData
import com.example.postapi.model.ModelData
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiInterface {
    @FormUrlEncoded
    @POST("/rima_beauty_gallery/beauty_gallery.php")
    fun getApi(@FieldMap params:HashMap<String,String>): Observable<ModelData>


  /*  @Multipart
    @POST("userProfileUpdate")
    fun userProfileUpdatecall(
        @Part("user_id") user_id: RequestBody?,
        @Part("name") name: RequestBody?,
        @Part("name_insertion") nameInsertion: RequestBody?,
        @Part("surname") surname: RequestBody?,
        @Part("email") email: RequestBody?,
        @Part("country_code") country_code: RequestBody?,
        @Part("mobile_number") mobile_number: RequestBody?,
        @Part user_image: MultipartBody.Part?
    ): Call<Forgotpass_res>*/

    /*@FormUrlEncoded
    @POST("logYourSteps")
    fun logYourStepscall(
        @Header("Authorization") authorization: String?,
        @Field("user_id") user_id: String?,
        @Field("smart_device_tracked_steps") smart_device_tracked_steps: String?,
        @Field("manual_steps") manual_steps: String?,
        @Field("activity") activity: String?,
        @Field("duration") duration: String?,
        @Field("converted_steps") converted_steps: String?,
        @Field("current_date") current_date: String?,
        @Field("language") language: String?
    ): Call<Step_res>*/

    /*@FormUrlEncoded
    @POST("getFeedCommentList")
    fun getFeedCommentListCall(
        @Field("feed_id") feed_id: String?,
        @Query("page") page: Int
    ): Call<Commentlist_res>*/
}