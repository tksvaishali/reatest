package au.com.realestate.hometime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import au.com.realestate.hometime.models.Tram;
import au.com.realestate.hometime.network.RequestToken;
import au.com.realestate.hometime.network.RequestTrams;
import au.com.realestate.hometime.network.RetrofitService;
import au.com.realestate.hometime.network.TramsApi;
import au.com.realestate.hometime.utility.CommonUtils;

public class MainActivity extends AppCompatActivity {

    private List<Tram> southTrams;
    private List<Tram> northTrams;

    private ListView northListView;
    private ListView southListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        northListView = (ListView) findViewById(R.id.northListView);
        southListView = (ListView) findViewById(R.id.southListView);
    }

    public void refreshClick(View view) {
        RetrofitService retrofit = new RetrofitService();
        TramsApi tramsApi = retrofit.createApiClient();
        try {
            String token = new RequestToken(tramsApi).execute("").get();
            this.northTrams = new RequestTrams(tramsApi, token).execute("4055").get();
            this.southTrams = new RequestTrams(tramsApi, token).execute("4155").get();
            showTrams();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void clearClick(View view) {
        northTrams = new ArrayList<>();
        southTrams = new ArrayList<>();
        showTrams();
    }

    private void showTrams() {

        List<String> northValues = new ArrayList<>();
        List<String> southValues = new ArrayList<>();

        for (Tram tram : northTrams) {
            String date = CommonUtils.dateFromDotNetDate(tram.predictedArrival).toString();
            northValues.add(date);
        }

        for (Tram tram : southTrams) {
            String date = CommonUtils.dateFromDotNetDate(tram.predictedArrival).toString();
            southValues.add(date);
        }

        northListView.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                northValues));

        southListView.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                southValues));
    }
}