package au.com.realestate.hometime.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * RetrofitService is used to create Retrofit instance
 */
public class RetrofitService {
    /**
     * This method creates a new instance of the API interface.
     *
     * @return TramsApi
     */
    public TramsApi createApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConstant.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        return retrofit.create(TramsApi.class);
    }
}
