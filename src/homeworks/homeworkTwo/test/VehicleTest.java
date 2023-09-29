import static org.assertj.core.api.Assertions.*;

import homeworks.homeworkTwo.main.Car;
import homeworks.homeworkTwo.main.Motorcycle;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import seminars.seminarTwo.main.Cart;
import seminars.seminarTwo.main.Shop;

public class VehicleTest {
    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setup() {
        car = new Car("Tesla", "Model X", 2023);
        motorcycle = new Motorcycle("Harley-Davidson", "Pan America", 2021);
    }

    @Test
    void isVehicleTest() {
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void is4WheelsOnCarTest() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void is2WheelsOnMotorcycleTest() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void carTDriveSpeedTest() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void motorcycleTDriveSpeedTest() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void carParkingTest() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void motorcycleParkingTest() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}
