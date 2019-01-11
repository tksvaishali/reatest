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
}
