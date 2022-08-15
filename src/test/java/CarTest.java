import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * # 2. 자동차 경주 게임 구현
 *
 * 기능 요구사항
 * - 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
 *   - 자동차는 이름이 있다.
 * 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 *   - 자동차는 위치가 있다.
 * - 자동차 이름은 쉼표(,)를 기준으로 구분한다.
 * - 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 * - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
 */
public class CarTest {

    private String carName = "ep";

    @Test
    @DisplayName("차의 이름은 5자를 초과할 수 없다")
    void car_name_less_than_5() {
        String carNameLengthMoreThan5 = "east_person";
        assertThatThrownBy(() -> new Car(carNameLengthMoreThan5)).isInstanceOf(IllegalArgumentException.class);
    }

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
