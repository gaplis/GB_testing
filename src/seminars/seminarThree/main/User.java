package seminars.seminarThree.main;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;

    }

    //3.6.
    public boolean auth(String name, String password) {
        if (name == this.name && password == this.password){
            this.isAuthenticate = true;
            return true;
        } else {
            return false;
        }
    }

}