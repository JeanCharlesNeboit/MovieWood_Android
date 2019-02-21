package com.example.moviewood.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.example.moviewood.R;
import com.example.moviewood.adapter.ScreeningAdapter;
import com.example.moviewood.model.Cine;
import com.example.moviewood.rest.ApiHelper;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ApiHelper.getInstance().getCineApi().getFile().enqueue(new Callback<Cine>() {
            @Override
            public void onResponse(Call<Cine> call, Response<Cine> response) {
                if (response.isSuccessful()) {
                    recyclerView.setAdapter(new ScreeningAdapter(response.body().movieShowtimes, MainActivity.this));
                }
            }

            @Override
            public void onFailure(Call<Cine> call, Throwable t) {

            }
        });
    }
}
