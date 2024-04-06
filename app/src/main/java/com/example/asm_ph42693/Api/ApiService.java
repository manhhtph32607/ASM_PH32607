package com.example.asm_ph42693.Api;

import com.example.asm_ph42693.Modal.SinhVien;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    // Link API :http://192.168.100.3:3000/api/students?masv=PH42693
    String DOMAIN = "http://192.168.100.3:3000/api/";

    ApiService apiService  = new Retrofit.Builder()
            .baseUrl(ApiService.DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);
    @GET("students")
    Call<List<SinhVien>> getData();
    @POST("students/add")
    Call<SinhVien> addStudent(@Body SinhVien sinhVien);

    @Multipart
    @POST("students/add")
    Call<SinhVien> addStudentPicker(
            @Part("masv") RequestBody masv,
            @Part("name") RequestBody name,
            @Part("point") RequestBody point,
            @Part MultipartBody.Part avatar);


    @DELETE("students/delete/{id}")
    Call<SinhVien> deleteStudent(@Path("id") String idStudent);


    @PUT("students/update/{id}")
    Call<SinhVien> updateStudent(@Path("id") String idStudent,
                                 @Body SinhVien sinhVien);
}
