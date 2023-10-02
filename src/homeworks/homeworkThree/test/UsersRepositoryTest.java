import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import homeworks.homeworkThree.main.User;
import homeworks.homeworkThree.main.UsersRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UsersRepositoryTest {

//    Задание 3: Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей,
//    кроме администраторов. Для этого, вам потребуется расширить класс User новым свойством,
//    указывающим, обладает ли пользователь админскими правами. Протестируйте данную функцию.

    UsersRepository usersRepository;
    List<User> users;

    @BeforeEach
    void setUp() {
        usersRepository = new UsersRepository();
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
        usersRepository.addUser(users.get(0));
        assertThat(usersRepository.findByName("admin")).isTrue();
    }

    @Test
    void addUserNotSuccessTest() {
        users.get(0).auth("admin", "1234qwert");
        usersRepository.addUser(users.get(0));
        assertThat(usersRepository.findByName("admin")).isFalse();
    }

    @Test
    void addManyUserSuccessTest() {
        users.get(0).auth("admin", "1234qwer");
        users.get(3).auth("slava", "12qwer34");
        usersRepository.addUser(users.get(0));
        usersRepository.addUser(users.get(3));
        assertThat(usersRepository.findByName("admin")).isTrue();
        assertThat(usersRepository.findByName("slava")).isTrue();
    }

    @Test
    void addManyUserButOneNotSuccessTest() {
        users.get(0).auth("admin", "1234qwer");
        users.get(3).auth("slava", "12qwer34");
        users.get(1).auth("ilya", "qwertas");
        usersRepository.addUser(users.get(0));
        usersRepository.addUser(users.get(3));
        usersRepository.addUser(users.get(1));
        assertThat(usersRepository.findByName("admin")).isTrue();
        assertThat(usersRepository.findByName("slava")).isTrue();
        assertThat(usersRepository.findByName("ilya")).isFalse();
    }

    @Test
    void logoutUsersTest(){
        users.get(0).auth("admin", "1234qwer");
        users.get(3).auth("slava", "12qwer34");
        users.get(1).auth("ilya", "qwer");
        usersRepository.addUser(users.get(0));
        usersRepository.addUser(users.get(3));
        usersRepository.addUser(users.get(1));
        usersRepository.logoutUsers();
        assertThat(usersRepository.findByName("admin")).isTrue();
        assertThat(usersRepository.findByName("slava")).isFalse();
        assertThat(usersRepository.findByName("ilya")).isFalse();
    }
}