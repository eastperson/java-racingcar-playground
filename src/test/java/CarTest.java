import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("차의 초기 위치값은 0이다.")
    void car_move_ahead() {
        String carName = "ep";
        Car car = new Car(carName);
        assertThat(car.name()).isEqualTo(carName);
        assertThat(car.position()).isEqualTo(0);
    }
}
