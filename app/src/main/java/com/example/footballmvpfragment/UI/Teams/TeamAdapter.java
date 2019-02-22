package com.example.footballmvpfragment.UI.Teams;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.footballmvpfragment.Detail.DetailTeamActivity;
import com.example.footballmvpfragment.Model.TeamsItem;
import com.example.footballmvpfragment.R;
import com.example.footballmvpfragment.Utils.Constans;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private final Context context;
    private final List<TeamsItem> teamsItemList;


    public TeamAdapter(Context context, List<TeamsItem> teamsItemList) {
        this.context = context;
        this.teamsItemList = teamsItemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_teams, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final TeamsItem teamsItem = teamsItemList.get(i);
        viewHolder.txtNameTeam.setText(teamsItem.getTeamName());
        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image_black_24dp);
        Glide.with(context).load(teamsItem.getTeamLogo()).apply(options).into(viewHolder.imgLogoTeam);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailTeamActivity.class).putExtra(Constans.KEY_DATA, teamsItem));
            }
        });
    }

    @Override
    public int getItemCount() {
        return teamsItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_logo_team)
        ImageView imgLogoTeam;
        @BindView(R.id.txt_name_team)
        TextView txtNameTeam;
        @BindView(R.id.card_view)
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
