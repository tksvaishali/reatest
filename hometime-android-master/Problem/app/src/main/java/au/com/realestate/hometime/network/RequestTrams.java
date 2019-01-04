package au.com.realestate.hometime.network;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import au.com.realestate.hometime.models.ApiResponse;
import au.com.realestate.hometime.models.Tram;
import retrofit2.Call;
import retrofit2.Response;

/**
 * RequestTrams is an AsyncTask to get tram details from webservice call
 */
public class RequestTrams extends AsyncTask<String, Integer, List<Tram>> {

    private TramsApi mApi;
    private String mToken;

    /**
     * Constructor to initialise variables
     *
     * @param api   TramsApi
     * @param token String representing the token
     */
    public RequestTrams(TramsApi api, String token) {
        this.mApi = api;
        this.mToken = token;
    }

    @Override
    protected List<Tram> doInBackground(String... stops) {

        Call<ApiResponse<Tram>> call = mApi.trams(stops[0], mToken);
        try {
            Response<ApiResponse<Tram>> resp = call.execute();
            return resp.body().responseObject;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}