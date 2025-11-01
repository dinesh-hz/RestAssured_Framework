package Payload;

public class LoginRequest {

    // this is for post method to put key and value in

    /*
     * JSONObject jsonObject = new JSONObject();
     *
     * jsonObject.put("email", "eve.holt@reqres.in");
     *
     * jsonObject.put("password", "cityslicka");
     */

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest [email=" + email + ", password=" + password + "]";
    }
}
