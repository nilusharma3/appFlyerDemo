package com.example.anil.appflyerdemo.r;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by anil on 2/22/18.
 */

public interface ApiInterface {

    String APP_VERSION_CHECK = "/appVersion/getCurrentVersions";

    /**
     * to get app versions
     *
     * @param lang language
     * @return object containing version data
     */
    @GET(APP_VERSION_CHECK)
    Call<CommonResponse> getAppVersion(@Header("content-language") String lang);
}
