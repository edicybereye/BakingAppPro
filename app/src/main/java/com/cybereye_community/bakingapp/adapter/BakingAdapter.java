package com.cybereye_community.bakingapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cybereye_community.bakingapp.R;
import com.cybereye_community.bakingapp.RecipeActivity;
import com.cybereye_community.bakingapp.model.Baking;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edikurniawan on 8/19/17.
 */

public class BakingAdapter extends RecyclerView.Adapter<BakingAdapter.BakingHolder> {
    Context mContext;
    List<Baking> bakings;

    public BakingAdapter(Context mContext, List<Baking> bakings) {
        this.mContext = mContext;
        this.bakings = bakings;
    }

    @Override
    public BakingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_baking, parent, false);
        return new BakingHolder(view);
    }

    @Override
    public void onBindViewHolder(final BakingHolder holder, final int position) {
            holder.Name.setText(bakings.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Baking data = bakings.get(position);
                    Intent i = new Intent(holder.itemView.getContext(), RecipeActivity.class);
                    i.putExtra("recipe", new GsonBuilder().create().toJson(data));
                    holder.itemView.getContext().startActivity(i);
                }
            });
    }

    @Override
    public int getItemCount() {
        return bakings.size();


    }

    class BakingHolder extends RecyclerView.ViewHolder{
        TextView Name;

        public BakingHolder(View itemView) {
            super(itemView);
            Name = (TextView)itemView.findViewById(R.id.name);

        }
    }
}
