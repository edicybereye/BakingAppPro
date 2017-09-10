package com.cybereye_community.bakingapp.util;

import com.cybereye_community.bakingapp.model.Baking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by edikurniawan on 8/19/17.
 */

public interface NetworkUtil {


    @GET("baking.json")
    Call<List<Baking>> getBaking();
}
