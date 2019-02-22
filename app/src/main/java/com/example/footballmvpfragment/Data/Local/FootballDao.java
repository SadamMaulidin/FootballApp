package com.example.footballmvpfragment.Data.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.footballmvpfragment.Model.TeamsItem;

import java.util.List;


@Dao
public interface FootballDao {

    @Insert
    void insertItem(TeamsItem teamsItem);

    @Query("SELECT * FROM teams WHERE idteam = :id")
    TeamsItem selectedItem(String id);

    @Delete
    void delete(TeamsItem teamsItem);

    @Query("SELECT * FROM teams ORDER BY strTeam ASC")
    List<TeamsItem> selectFavorite();

}
