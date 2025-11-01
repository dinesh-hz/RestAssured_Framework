package Payload;

import java.io.Serializable;

public class Address_dataes implements Serializable {

    private static final long serialVersionUID = 1L;

    private String city;

    private String landmark;

    private String dirst;

    /*
     * public Address_dataes() { super(); }
     */

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getDirst() {
        return dirst;
    }

    public void setDirst(String dirst) {
        this.dirst = dirst;
    }

    @Override
    public String toString() {
        return "Address_dataes [city=" + city + ", landmark=" + landmark + ", dirst=" + dirst + "]";
    }
}
