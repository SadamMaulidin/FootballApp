package com.example.footballmvpfragment.UI.Favorite;

import android.content.Context;

import com.example.footballmvpfragment.Data.Local.FootballDatabase;

public class FavoritePresenter implements FavoriteContract.Presenter {

    private final FavoriteContract.View view;
    private FootballDatabase footballDatabase;

    public FavoritePresenter(FavoriteContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListTeams(Context context) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        if (footballDatabase.footballDao().selectFavorite() != null){
            view.showDataList(footballDatabase.footballDao().selectFavorite());
        }else {
            view.showFailure("Tidak Ada Club Favorite");
        }
        view.hideRefresh();

    }
}
