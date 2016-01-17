package fr.geobulance.tabletapp.ObjectType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by louis on 17/01/2016.
 */
public class Events {
    private String _id;
    private String action;
    private double lng;
    private double lat;
    private String imei;
    private Date date;

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");;

    public Date getDate() {
        return date;
    }

    public Events(String _id, String action, double lng, double lat, String imei, String created) {
        this._id = _id;
        this.action = action;
        this.lng = lng;
        this.lat = lat;
        this.imei = imei;

        try {
            date = formatter.parse(created);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setDate() throws ParseException {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
