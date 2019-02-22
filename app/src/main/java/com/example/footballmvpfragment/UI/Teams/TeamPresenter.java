package com.example.footballmvpfragment.UI.Teams;

import com.example.footballmvpfragment.Data.Remote.ApiClient;
import com.example.footballmvpfragment.Data.Remote.ApiInterface;
import com.example.footballmvpfragment.Model.TeamResponse;
import com.example.footballmvpfragment.Utils.Constans;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamPresenter implements TeamContract.Presenter {

    private final TeamContract.Vie vie;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public TeamPresenter(TeamContract.Vie vie) {
        this.vie = vie;
    }

    @Override
    public void getDataListTeam() {
        vie.showProgress();
        Call<TeamResponse> call = apiInterface.getAllTeam(Constans.s, Constans.c);
        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                vie.hideProgress();
                if (response.body() != null){
                    vie.showDataList(response.body().getTeams());
                }else {
                    vie.showfailure("Data Kosong");
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                vie.hideProgress();
                vie.showfailure(t.getMessage());
            }
        });
    }
}
