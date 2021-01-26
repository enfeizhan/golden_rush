package com.example.learnandroid;

import com.example.learnandroid.model.AddCameraResponse;
import com.example.learnandroid.model.RemoveCameraResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {
    @POST("/api/video/add_camera")
    Call<AddCameraResponse> AddCamera(@Body HashMap<String, String> body);

    @POST("/api/video/remove_camera")
    Call<RemoveCameraResponse> RemoveCamera(@Body HashMap<String, String> body);
}
