package com.example.footballmvpfragment.UI.Teams;

import com.example.footballmvpfragment.Model.TeamsItem;

import java.util.List;

public interface TeamContract {
    interface Vie{
        void showProgress();
        void hideProgress();
        void showDataList(List<TeamsItem> teamsItemList);
        void showfailure(String msg);
    }
    interface Presenter{
        void getDataListTeam();
    }
}
