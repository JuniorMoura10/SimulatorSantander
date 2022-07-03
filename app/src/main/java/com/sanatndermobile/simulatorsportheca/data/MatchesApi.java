package com.sanatndermobile.simulatorsportheca.data;

import com.sanatndermobile.simulatorsportheca.domain.Match;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchesApi {

    @GET("jogos.json")
    Call<List<Match>> getMatches();
}
