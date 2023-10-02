import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.seminarThree.main.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    //    Задание 6: Разработайте класс User с методом аутентификации по логину и паролю. Метод должен возвращать true, если
//    введенные логин и пароль корректны, иначе false. Протестируйте все методы

    User user;

    @BeforeEach
    void setupUser() {
        user = new User("admin", "1234qwer", true);
    }

    @Test
    void authSuccessUserTest() {
        assertThat(user.auth("admin", "1234qwer")).isTrue();
    }

    @Test
    void authNotSuccessNameUserTest() {
        assertThat(user.auth("admins", "1234qwer")).isFalse();
    }

    @Test
    void authNotSuccessPassUserTest() {
        assertThat(user.auth("admin", "1234qwert")).isFalse();
    }
}