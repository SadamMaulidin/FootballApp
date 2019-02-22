package com.example.footballmvpfragment.Data.Remote;

import com.example.footballmvpfragment.Model.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/v1/json/1/search_all_teams.php")
    Call<TeamResponse> getAllTeam(@Query("s") String s, @Query("c") String c);

}
