package com.hussein.youxeltask.data.remote;

import com.hussein.youxeltask.data.remote.response.MatchesResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

  @GET("https://livescore-api.com/api-client/scores/live.json")
  Single<MatchesResponse> getLiveMatches(@Query("key") String key, @Query("secret") String secret);
}