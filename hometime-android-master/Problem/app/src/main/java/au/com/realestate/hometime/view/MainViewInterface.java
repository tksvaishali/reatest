package au.com.realestate.hometime.view;

import java.util.List;

/**
 * MainViewInterface is an interface for View update
 *
 * @param <T>
 */
public interface MainViewInterface<T> {
    /**
     * Method to update north list
     *
     * @param responseObject Response list
     */
    void updateNorthListData(List<T> responseObject);

    /**
     * Method to update south list
     *
     * @param responseObject Response list
     */
    void updateSouthListData(List<T> responseObject);

    /**
     * Method to handle error
     */
    void displayErrorMessage();
}
