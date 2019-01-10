package au.com.realestate.hometime.presenter;

import java.util.concurrent.ExecutionException;

import au.com.realestate.hometime.network.RequestToken;
import au.com.realestate.hometime.network.RequestTrams;
import au.com.realestate.hometime.network.RetrofitService;
import au.com.realestate.hometime.network.TramsApi;
import au.com.realestate.hometime.view.MainViewInterface;

/**
 * MainPresenter class is the Presenter between view and mode.
 */
public class MainPresenter {
    /**
     * MainViewInterface Instance
     */
    private MainViewInterface mView;

    /**
     * RetrofitService Instance
     */
    private RetrofitService mRetrofitService;

    /**
     * Constructor to initialise variable
     *
     * @param pView MainViewInterface instance
     */
    public MainPresenter(MainViewInterface pView) {
        this.mView = pView;

        if (mRetrofitService == null) {
            mRetrofitService = new RetrofitService();
        }
    }

    /**
     * This method will invoke the webservice call using retrofit service
     */
    public void callWebservice() {
        RetrofitService retrofit = new RetrofitService();
        TramsApi tramsApi = retrofit.createApiClient();
        try {
            String token = new RequestToken(tramsApi).execute("").get();
            mView.updateNorthListData(new RequestTrams(tramsApi, token, mView).execute("4055").get());
            mView.updateSouthListData(new RequestTrams(tramsApi, token, mView).execute("4155").get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            mView.displayErrorMessage();
        }
    }
}