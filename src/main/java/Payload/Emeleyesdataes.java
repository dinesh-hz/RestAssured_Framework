package Payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Emeleyesdataes implements Serializable {

    private static final long serialVersionUID = 1L;

    public String firstname;

    public String lastename;

    public String emailid;

    public Address_dataes addres;

    public List<String> skiles;



    /*
     * public Emeleyesdataes() { super(); }
     */

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastename() {
        return lastename;
    }

    public void setLastename(String lastename) {
        this.lastename = lastename;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Address_dataes getAddres() {
        return addres;
    }

    public void setAddres(Address_dataes addres) {
        this.addres = addres;
    }

    public List<String> getSkiles() {
        return skiles;
    }

    public void setSkiles(List<String> skiles) {
        this.skiles = skiles;
    }

    @Override
    public String toString() {
        return "Emeleyesdataes [firstname=" + firstname + ", lastename=" + lastename + ", emailid=" + emailid
                + ", addres=" + addres + ", skiles=" + skiles + "]";
    }
}
