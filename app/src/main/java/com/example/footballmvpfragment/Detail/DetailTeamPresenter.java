package com.example.footballmvpfragment.Detail;

import android.content.Context;
import android.os.Bundle;

import com.example.footballmvpfragment.Data.Local.FootballDatabase;
import com.example.footballmvpfragment.Model.TeamsItem;
import com.example.footballmvpfragment.Utils.Constans;

public class DetailTeamPresenter implements DetailTeamContract.Presenter {

    private final DetailTeamContract.View view;
    private FootballDatabase footballDatabase;

    public DetailTeamPresenter(DetailTeamContract.View view) {
        this.view = view;
    }

    @Override
    public void getDetailteam(Bundle bundle) {
        if (bundle != null){
            TeamsItem teamsItem = (TeamsItem) bundle.getSerializable(Constans.KEY_DATA);
            view.ahowDetailTeam(teamsItem);
        }else {
            view.showFailure("Data Kosong");
        }
    }

    @Override
    public void addToFavorite(Context context, TeamsItem teamsItem) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        footballDatabase.footballDao().insertItem(teamsItem);
        view.showSucces("Tersimpan");
    }

    @Override
    public void removeFavorite(Context context, TeamsItem teamsItem) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        footballDatabase.footballDao().delete(teamsItem);
        view.showSucces("Terhapus");
    }

    @Override
    public Boolean checkFavorite(Context context, TeamsItem teamsItem) {

        Boolean bfavorite = false;
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        return bfavorite = footballDatabase.footballDao().selectedItem(teamsItem.getIdTeam()) != null;
    }
}
