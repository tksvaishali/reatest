package au.com.realestate.hometime.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import au.com.realestate.hometime.R;
import au.com.realestate.hometime.models.Tram;
import au.com.realestate.hometime.presenter.MainPresenter;
import au.com.realestate.hometime.utility.CommonUtils;

/**
 * MainActivity is activity which displays the data in list
 */
public class MainActivity extends AppCompatActivity implements MainViewInterface {
    private List<Tram> southTrams;
    private List<Tram> northTrams;

    private ListView northListView;
    private ListView southListView;

    private MainPresenter mMainPresenter;
    private boolean isErrorDialogDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        northListView = (ListView) findViewById(R.id.northListView);
        southListView = (ListView) findViewById(R.id.southListView);

        mMainPresenter = new MainPresenter(this);
    }

    /**
     * This method is called when refresh button is tapped and will call webservice
     *
     * @param view View
     */
    public void refreshClick(View view) {
        mMainPresenter.callWebservice();
    }

    /**
     * This method is called when clear button is tapped and will clear the list
     *
     * @param view View
     */
    public void clearClick(View view) {
        northTrams = new ArrayList<>();
        southTrams = new ArrayList<>();
        showTrams();
    }

    /**
     * This method will update list
     */
    private void showTrams() {
        displayNorthList(northTrams);
        displaySouthList(southTrams);
    }

    /**
     * This method will display error dialog
     */
    private void displayErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.error_message));
        builder.setCancelable(false);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                isErrorDialogDisplayed = false;
                dialog.dismiss();
            }
        });

        if (!isErrorDialogDisplayed) {
            AlertDialog alert = builder.create();
            alert.setCanceledOnTouchOutside(false);
            alert.show();
            isErrorDialogDisplayed = true;
        }
    }

    @Override
    public void updateNorthListData(List responseObject) {
        displayNorthList(responseObject);
    }

    /**
     * Method to display north tram list
     *
     * @param responseObject Response list
     */
    private void displayNorthList(List responseObject) {
        this.northTrams = responseObject;
        List<String> northValues = new ArrayList<>();

        if (northTrams != null) {
            for (Tram tram : northTrams) {
                String date = CommonUtils.dateFromDotNetDate(tram.predictedArrival).toString();
                northValues.add(date);
            }
            northListView.setAdapter(new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    northValues));
        }
    }

    @Override
    public void updateSouthListData(List responseObject) {
        displaySouthList(responseObject);
    }

    /**
     * Method to display south tram list
     *
     * @param responseObject Response list
     */
    public void displaySouthList(List responseObject) {
        this.southTrams = responseObject;
        List<String> southValues = new ArrayList<>();

        if (southTrams != null) {
            for (Tram tram : southTrams) {
                String date = CommonUtils.dateFromDotNetDate(tram.predictedArrival).toString();
                southValues.add(date);
            }

            southListView.setAdapter(new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    southValues));
        }
    }


    @Override
    public void displayErrorMessage() {
        displayErrorDialog();
    }
}