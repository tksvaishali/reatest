package au.com.realestate.hometime.view;

import java.util.List;

import au.com.realestate.hometime.models.Tram;

public interface MainViewInterface <T>{
    void updateNorthListData(List<T> responseObject);
    void updateSouthListData(List<T> responseObject);

    void displayErrorMessage();
}
