import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.seminarThree.main.User;
import seminars.seminarThree.main.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class UserRepositoryTest {

//    Задание 7: Добавьте класс UserRepository для управления пользователями. В этот класс должен быть включен метод
//    addUser, который добавляет пользователя в систему, если он прошел аутентификацию. Покройте тестами новую
//            функциональность

    UserRepository userRepository;
    List<User> users;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        users = new ArrayList<>();
        users.add(new User("admin", "1234qwer", true));
        users.add(new User("ilya", "qwer", false));
        users.add(new User("katya", "qwer1234", false));
        users.add(new User("slava", "12qwer34", false));
        users.add(new User("svetaa", "1234", false));
    }

    @Test
    void addUserSuccessTest() {
        users.get(0).auth("admin", "1234qwer");
        userRepository.addUser(users.get(0));
        assertThat(userRepository.findByName("admin")).isTrue();
    }

    @Test
    void addUserNotSuccessTest() {
        users.get(0).auth("admin", "1234qwert");
        userRepository.addUser(users.get(0));
        assertThat(userRepository.findByName("admin")).isFalse();
    }

    @Test
    void addManyUserSuccessTest() {
        users.get(0).auth("admin", "1234qwer");
        users.get(3).auth("slava", "12qwer34");
        userRepository.addUser(users.get(0));
        userRepository.addUser(users.get(3));
        assertThat(userRepository.findByName("admin")).isTrue();
        assertThat(userRepository.findByName("slava")).isTrue();
    }

    @Test
    void addManyUserButOneNotSuccessTest() {
        users.get(0).auth("admin", "1234qwer");
        users.get(3).auth("slava", "12qwer34");
        users.get(1).auth("ilya", "qwertas");
        userRepository.addUser(users.get(0));
        userRepository.addUser(users.get(3));
        userRepository.addUser(users.get(1));
        assertThat(userRepository.findByName("admin")).isTrue();
        assertThat(userRepository.findByName("slava")).isTrue();
        assertThat(userRepository.findByName("ilya")).isFalse();
    }
}