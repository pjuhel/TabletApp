package fr.geobulance.tabletapp.ObjectType;

/**
 * Created by juhel on 16/01/2016.
 */
public class Ambulances {
    private String uuid;
    private double lat;
    private double lng;
    private String immatriculation;
    private String created;

    public void Ambulances(String uuid, double lat, double lng, String immatriculation, String created){
        this.uuid = uuid;
        this.lat = lat;
        this.lng = lng;
        this.immatriculation = immatriculation;
        this.created = created;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }



    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
