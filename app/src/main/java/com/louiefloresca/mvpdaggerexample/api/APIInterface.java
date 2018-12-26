package com.louiefloresca.mvpdaggerexample.api;


import com.louiefloresca.mvpdaggerexample.data.Result;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/v1/gifs/trending")
    Observable<Result> getGiphyTrending(@Query("api_key") String apiKey, @Query("limit") int limit,
                                        @Query("offset") int offset
    );
}
