package com.finalproject.uread.topic.main.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finalproject.uread.GetReadApplication;
import com.finalproject.uread.R;
import com.finalproject.uread.topic.main.models.Read;
import com.finalproject.uread.topic.main.service.ApiMain;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by paulo.losbanos on 10/02/2017.
 */

public class SearchFragment extends Fragment {
    TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        ApiMain api = GetReadApplication.mRetrofit.create(ApiMain.class);
        Call<List<Read>> getCall = api.getAllReads("001");

        getCall.enqueue(new Callback<List<Read>>() {
            @Override
            public void onResponse(Call<List<Read>> call, Response<List<Read>> response) {
                for (int i = 0;i < response.body().size();i++) {
                    Log.e("Search",response.body().get(i).getTitle());
                }
            }

            @Override
            public void onFailure(Call<List<Read>> call, Throwable t) {

            }
        });


        return v;
    }
}
