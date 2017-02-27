package com.finalproject.uread.topic.main.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finalproject.uread.GetReadApplication;
import com.finalproject.uread.R;
import com.finalproject.uread.topic.main.adapters.ReadAdapter;
import com.finalproject.uread.topic.main.models.Read;
import com.finalproject.uread.topic.main.service.ApiMain;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by paulo.losbanos on 10/02/2017.
 */

public class SearchFragment extends Fragment {

    List<Read> readList = new ArrayList<>();
    ReadAdapter readAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        RecyclerView rv = (RecyclerView) v.findViewById(R.id.recycler_view);
        readAdapter = new ReadAdapter(readList);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(readAdapter);

        ApiMain api = GetReadApplication.mRetrofit.create(ApiMain.class);
        Call<List<Read>> getCall = api.getAllReads("001");

        getCall.enqueue(new Callback<List<Read>>() {
            @Override
            public void onResponse(Call<List<Read>> call, Response<List<Read>> response) {
                readAdapter.swap(response.body());
            }

            @Override
            public void onFailure(Call<List<Read>> call, Throwable t) {
                Log.e("Failure",new Gson().toJson(t));
            }
        });


        return v;
    }
}
