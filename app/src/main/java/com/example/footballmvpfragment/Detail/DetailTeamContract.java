package com.example.footballmvpfragment.Detail;

import android.content.Context;
import android.os.Bundle;

import com.example.footballmvpfragment.Model.TeamsItem;

public interface DetailTeamContract {
    interface View{
        void ahowDetailTeam(TeamsItem teamsItem);
        void showFailure(String msg);
        void showSucces(String msg);
    }
    interface Presenter{
        void getDetailteam(Bundle bundle);
        void addToFavorite(Context context, TeamsItem teamsItem);
        void removeFavorite(Context context, TeamsItem teamsItem);
        Boolean checkFavorite(Context context, TeamsItem teamsItem);
    }
}
