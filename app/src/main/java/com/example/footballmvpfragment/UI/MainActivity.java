package com.example.footballmvpfragment.UI;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.footballmvpfragment.R;
import com.example.footballmvpfragment.UI.Favorite.FavoriteFragment;
import com.example.footballmvpfragment.UI.Teams.TeamsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.flContainer)
    FrameLayout flContainer;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_teams:
                    getSupportActionBar().setTitle("Teams");
                    TeamsFragment teamsFragment = new TeamsFragment();
                    //menampilkan fragment team
                    loadFragment(teamsFragment);
                    return true;
                case R.id.navigation_favorite:
                    getSupportActionBar().setTitle("Favorite");
                    FavoriteFragment favoriteFragment = new FavoriteFragment();
                    //menampilkan fragment favofite
                    loadFragment(favoriteFragment);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //mengubah title
        getSupportActionBar().setTitle("Teams");

        //membuat objek fragment team
        TeamsFragment teamsFragment = new TeamsFragment();
        loadFragment(teamsFragment);

        FavoriteFragment favoriteFragment = new FavoriteFragment();
        loadFragment(favoriteFragment);
    }

    private void loadFragment(Fragment fragment){
        //menampilkan fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
