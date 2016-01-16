package fr.geobulance.tabletapp;

/**
 * Created by louis on 16/01/2016.
 */
public class Beacon {
    private String uuid;
    private String major;
    private String minor;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public Beacon(String uuid, String major, String minor) {

        this.uuid = uuid;
        this.major = major;
        this.minor = minor;
    }
}
