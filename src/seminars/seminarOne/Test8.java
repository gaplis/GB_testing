//Используйте заготовку класса Hero и напишите следующие проверки для объекта Hero с использованием
//        assert:
//        1. Проверить, что герой создался с именем Emmett
//        2. Проверить, что значение прочности брони героя равно 50
//        3. Проверить, что у героя оружие типа sword
//        4. Проверить содержимое инвентаря героя (размер 3, содержимое "Bow", "Axe", "Gold", порядок
//        не важен)
//        5. Проверить, что герой это человек (свойство isHuman)


package seminars.seminarOne;

import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class Test8 {
    public static void main(String[] args) {
        Hero emmett = getHero();
        checkingHero(emmett);
    }

    private static Hero getHero() {
        List<String> heroBag = Arrays.asList("Bow", "Axe", "Gold");
        Hero emmett = new Hero("Emmett", 50, "sword", heroBag, true);
        return emmett;
    }

    public static void checkingHero(Hero hero) {
        assertThat(hero.getName()).isEqualTo("Emmett");
        assertThat(hero.getArmorStrength()).isEqualTo(50);
        assertThat(hero.getWeapon()).isEqualTo("sword");
        assertThat(hero.getBag()).isNotEmpty().hasSize(3).contains("Bow", "Axe", "Gold");
        assertThat(hero.isHuman()).isEqualTo(true);
    }


}

