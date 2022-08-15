import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    @DisplayName("레이스에 여러 자동차들이 참가할 수 있다.")
    void race_test() {
        List<Car> cars = Arrays.asList(new Car("ep"), new Car("kim"));
        Race race = new Race(cars);
        assertThat(race.participants()).containsAll(cars);
    }
}
