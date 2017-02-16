package com.finalproject.uread.topic.main.service;

import com.finalproject.uread.topic.main.models.Read;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by paulo.losbanos on 10/02/2017.
 */

public interface ApiMain {

    @GET("/reads/{id}")
    Call<List<Read>> getAllReads(@Path("id") String id);

}
