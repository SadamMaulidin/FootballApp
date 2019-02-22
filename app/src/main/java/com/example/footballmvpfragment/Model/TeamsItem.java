package com.example.footballmvpfragment.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "teams")
public class TeamsItem implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "idteam")
    @SerializedName("idTeam")
    @NonNull private String idTeam;

    @ColumnInfo(name = "strTeam")
    @SerializedName("strTeam")
    private String teamName;

    @ColumnInfo(name = "strTeamBadge")
    @SerializedName("strTeamBadge")
    private String teamLogo;

    @ColumnInfo(name = "strLeague")
    @SerializedName("strLeague")
    private String league;

    @ColumnInfo(name = "strDescriptionEN")
    @SerializedName("strDescriptionEN")
    private String descript;

    public TeamsItem(String idTeam, String teamName, String teamLogo, String league, String descript) {
        this.idTeam = idTeam;
        this.teamName = teamName;
        this.teamLogo = teamLogo;
        this.league = league;
        this.descript = descript;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
