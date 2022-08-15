import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private String carName = "ep";

    @Test
    @DisplayName("차의 초기 위치값은 0이다")
    void car_init() {
        Car car = new Car(carName);
        assertThat(car.name()).isEqualTo(carName);
        assertThat(car.position()).isEqualTo(0);
    }

    @Test
    @DisplayName("차는 앞으로 1씩 전진할 수 있다")
    void car_move_ahead() {
        Car car = new Car(carName);
        car.moveAhead();
        assertThat(car.position()).isEqualTo(1);
    }
}
