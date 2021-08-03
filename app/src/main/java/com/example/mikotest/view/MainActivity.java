package com.example.mikotest.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.example.mikotest.R;
import com.example.mikotest.adapter.MyAdapter;
import com.example.mikotest.modal.Data;
import com.example.mikotest.modal.Records;
import com.example.mikotest.modal.ResponseData;
import com.example.mikotest.rest.ApiClient;
import com.example.mikotest.rest.ApiInterface;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView myRecyclerView;
    private MyAdapter recyclerAdapter ;
    List<Records> recordsList = new ArrayList<>();
    List<Data> dataList;
    Context context;

    private void loadData() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseData> call = apiService.getRecords();
        call.enqueue(new retrofit2.Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                Log.d("response",response.toString());
                int statusCode = response.code();
                    Data data;
                 //    Log.w("resedatasync", new Gson().toJson(response));
                    data = response.body().data;
                    recordsList = data.getRecordsArrayList();
                    recyclerAdapter = new MyAdapter(getApplicationContext(),recordsList);
                    recyclerAdapter.notifyDataSetChanged();
                    myRecyclerView.setAdapter(recyclerAdapter);
                myRecyclerView.setHasFixedSize(true);
                myRecyclerView.setItemViewCacheSize(20);
                myRecyclerView.setDrawingCacheEnabled(true);
                myRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
                    Log.d("data",data.toString());
                String s = response.body().toString();
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }

        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerView = findViewById(R.id.rv);
        context = getApplicationContext();
        System.out.println("declared rv");
        System.out.println("set layout manager");
        recyclerAdapter = new MyAdapter(context,recordsList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, true);
        myRecyclerView.setLayoutManager(mLayoutManager);
        System.out.println("initialize adapter");
        loadData();
    }
}