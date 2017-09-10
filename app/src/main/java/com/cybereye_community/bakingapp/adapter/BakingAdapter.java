package com.cybereye_community.bakingapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cybereye_community.bakingapp.R;
import com.cybereye_community.bakingapp.model.Baking;

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
    public void onBindViewHolder(BakingHolder holder, int position) {
            holder.Name.setText(bakings.get(position).getName());
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
