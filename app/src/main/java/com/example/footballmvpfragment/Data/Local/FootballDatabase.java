package com.example.footballmvpfragment.Data.Local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.footballmvpfragment.Model.TeamsItem;

@Database(entities = TeamsItem.class, version = 1)
public abstract class FootballDatabase extends RoomDatabase {

    public abstract FootballDao footballDao();
    private static FootballDatabase footballDatabase;
    public static FootballDatabase getFootballDatabase(Context context){
        synchronized (FootballDatabase.class){
            if (footballDatabase == null){
                footballDatabase = Room.databaseBuilder(context, FootballDatabase.class,"dbFootball").allowMainThreadQueries().build();
            }
        }return footballDatabase;
    }

}
