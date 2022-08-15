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

    @Test
    @DisplayName("자동차 이름은 쉼표를 기준으로 구분해서 입력한다.")
    void race_participants_input_test() {
        String carNames = "ep,kim";
        StringToCars stringToCars = new StringToCars(carNames);
        Race race = new Race(stringToCars.toCars());

        List<Car> cars = Arrays.asList(new Car("ep"), new Car("kim"));
        Race targetRace = new Race(cars);

        assertThat(race.participants()).containsAll(targetRace.participants());
    }

    @Test
    @DisplayName("레이스의 매 라운드를 진행한다.")
    void race_next_round() {
        String carNames = "ep,kim";
        StringToCars stringToCars = new StringToCars(carNames);
        Race race = new Race(stringToCars.toCars());
        Board initBoard = race.currentBoard();
        race.nextRound();
        Board board = race.currentBoard();
        assertThat(board.round()).isEqualTo(initBoard.round() + 1);
    }
}
