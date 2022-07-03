package com.sanatndermobile.simulatorsportheca.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.sanatndermobile.simulatorsportheca.R;
import com.sanatndermobile.simulatorsportheca.data.MatchesApi;
import com.sanatndermobile.simulatorsportheca.databinding.ActivityMainBinding;
import com.sanatndermobile.simulatorsportheca.domain.Match;
import com.sanatndermobile.simulatorsportheca.ui.adapter.MatchesAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MatchesApi matchesApi;
    private RecyclerView.Adapter matchesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupHttpClient();
        setupMatchesList();
        setupMatchesRefresh();
        setupFloatingActionButton();
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://juniormoura10.github.io/simulado-de-partidas-copa2022/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        matchesApi = retrofit.create(MatchesApi.class);
    }

    private void setupMatchesList() {
        binding.rvMatches.setHasFixedSize(true);
        binding.rvMatches.setLayoutManager(new LinearLayoutManager(this));
        matchesApi.getMatches().enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                if (response.isSuccessful()) {
                    List<Match> matches = response.body();
                    matchesAdapter = new MatchesAdapter(matches);
                    binding.rvMatches.setAdapter(matchesAdapter);
                } else{
                    showErrorMesage();
                }
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {
                    showErrorMesage();
            }
        });
    }

    private void setupMatchesRefresh() {
        //TODO Atualizar as partidas nas ações de swipe.
    }

    private void setupFloatingActionButton() {
        //TODO implementar ação de clique do action button.
    }

    private void showErrorMesage() {
        //Snackbar.make(binding.fabSimulate, R.string.errorApi, Snackbar.LENGTH_LONG).show();
    }




}
