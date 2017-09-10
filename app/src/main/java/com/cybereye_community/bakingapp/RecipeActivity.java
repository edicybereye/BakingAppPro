package com.cybereye_community.bakingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.cybereye_community.bakingapp.model.Baking;
import com.google.gson.GsonBuilder;

public class RecipeActivity extends AppCompatActivity {
    Baking baking;
    String coba[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        baking = new GsonBuilder()
                .create()
                .fromJson(RecipeActivity.this
                        .getIntent()
                        .getStringExtra("recipe"),Baking.class);
        getSupportActionBar().setTitle(baking.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                supportFinishAfterTransition();
                super.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
