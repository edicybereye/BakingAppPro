package com.cybereye_community.bakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.cybereye_community.bakingapp.adapter.BakingAdapter;
import com.cybereye_community.bakingapp.model.Baking;
import com.cybereye_community.bakingapp.util.NetworkRetrofit;
import com.cybereye_community.bakingapp.util.NetworkUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.bakingView)
    RecyclerView recyclerView;

    List<Baking> bakings;
    BakingAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Baking App");
        ButterKnife.bind(this);
        bakings = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        initData();
    }

    void initData(){
        NetworkUtil networkUtil = NetworkRetrofit.getRetrofit()
                .create(NetworkUtil.class);
        Call<List<Baking>> call = networkUtil.getBaking();
        call.enqueue(new Callback<List<Baking>>() {
            @Override
            public void onResponse(Call<List<Baking>> call, Response<List<Baking>> response) {
                bakings = response.body();
                adapter = new BakingAdapter(MainActivity.this, bakings);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Baking>> call, Throwable t) {

            }
        });
    }
}
