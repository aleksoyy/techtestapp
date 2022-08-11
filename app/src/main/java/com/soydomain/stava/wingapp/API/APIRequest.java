package com.soydomain.stava.wingapp.API;

import com.soydomain.stava.wingapp.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequest {

    @FormUrlEncoded
    @POST ("authlogin.php")
    Call<ResponseModel> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("getproduct.php")
    Call<ResponseModel> getproductfunct();

    @FormUrlEncoded
    @POST("getspecprod.php")
    Call<ResponseModel> getspecprod(
            @Field("pcode") String pcode
    );
}
