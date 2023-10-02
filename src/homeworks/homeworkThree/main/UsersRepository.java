package homeworks.homeworkThree.main;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {

    // Тут можно хранить аутентифицированных пользователей
    public List<User> data = new ArrayList<>();

    public void addUser(User user) {
       if (user.isAuthenticate) {
           data.add(user);
       }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logoutUsers(){
        List<User> logoutUsers = new ArrayList<>();
        for (User user : data) {
            if (!user.isAdmin){
                user.isAuthenticate = false;
                logoutUsers.add(user);
            }
        }
        for (User user : logoutUsers){
            data.remove(user);
        }
    }

}