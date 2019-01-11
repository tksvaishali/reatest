package au.com.realestate.hometime.models;

import com.squareup.moshi.Json;

/**
 * Model class Tram
 */
public class Tram {
    @Json(name = "Destination")
    public String destination;
    @Json(name = "PredictedArrivalDateTime")
    public String predictedArrival;
    @Json(name = "RouteNo")
    public String routeNo;

    /**
     * Get Destination
     *
     * @return the destination value
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Set Destination
     *
     * @param destination sets the destination value
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Get PredictedArrival
     *
     * @return the predicted arrival value
     */
    public String getPredictedArrival() {
        return predictedArrival;
    }

    /**
     * Set PredictedArrival
     *
     * @param predictedArrival the predicted arrival value
     */
    public void setPredictedArrival(String predictedArrival) {
        this.predictedArrival = predictedArrival;
    }

    /**
     * Get Route No
     *
     * @return the route no
     */
    public String getRouteNo() {
        return routeNo;
    }

    /**
     * Set Route No
     *
     * @param routeNo the route no
     */
    public void setRouteNo(String routeNo) {
        this.routeNo = routeNo;
    }
}
