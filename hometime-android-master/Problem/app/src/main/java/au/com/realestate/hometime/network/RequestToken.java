package au.com.realestate.hometime.network;

import android.os.AsyncTask;

import java.io.IOException;

import au.com.realestate.hometime.models.ApiResponse;
import au.com.realestate.hometime.models.Token;
import retrofit2.Call;

/**
 * RequestToken is an AsyncTask to get the token for webservice call
 */
public class RequestToken extends AsyncTask<String, Integer, String> {

    private TramsApi mApi;

    /**
     * Constructor to initialise variable
     *
     * @param api TramsApi instance
     */
    public RequestToken(TramsApi api) {
        this.mApi = api;
    }

    @Override
    protected String doInBackground(String... params) {
        Call<ApiResponse<Token>> call = mApi.token();
        try {
            return call.execute().body().responseObject.get(0).value;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}