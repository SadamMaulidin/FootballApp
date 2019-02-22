package com.example.footballmvpfragment.UI.Favorite;

import android.content.Context;

import com.example.footballmvpfragment.Model.TeamsItem;

import java.util.List;

public interface FavoriteContract {
    interface View{
        void showDataList(List<TeamsItem> teamsItemsList);
        void showFailure(String msg);
        void hideRefresh();
    }

    interface Presenter{
        void getDataListTeams(Context context);
    }

}
