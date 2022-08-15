import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {

    private Integer finalRound = 5;

    @Test
    @DisplayName("레이스에 여러 자동차들이 참가할 수 있다.")
    void race_test() {
        List<Car> cars = Arrays.asList(new Car("ep"), new Car("kim"));
        Race race = new Race(cars, finalRound);
        assertThat(race.participants()).containsAll(cars);
    }

    @Test
    @DisplayName("자동차 이름은 쉼표를 기준으로 구분해서 입력한다.")
    void race_participants_input_test() {
        String carNames = "ep,kim";
        StringToCars stringToCars = new StringToCars(carNames);
        Race race = new Race(stringToCars.toCars(), finalRound);

        List<Car> cars = Arrays.asList(new Car("ep"), new Car("kim"));
        Race targetRace = new Race(cars, finalRound);

        assertThat(race.participants()).containsAll(targetRace.participants());
    }

    @Test
    @DisplayName("레이스의 매 라운드를 진행한다")
    void race_next_round() {
        String carNames = "ep,kim";
        StringToCars stringToCars = new StringToCars(carNames);
        Race race = new Race(stringToCars.toCars(), finalRound);
        Board initBoard = race.currentBoard();
        race.nextRound();
        Board board = race.currentBoard();
        assertThat(board.round()).isEqualTo(initBoard.round() + 1);
    }

    @Test
    @DisplayName("마지막 라운드에 도달하면 race 는 멈춘다.")
    void race_end() {
        String carNames = "ep,kim";
        StringToCars stringToCars = new StringToCars(carNames);
        Race race = new Race(stringToCars.toCars(), finalRound);
        for (int i = 0; i < finalRound; i++) {
            race.nextRound();
        }
        assertThat(race.end()).isTrue();
    }

    @Test
    @DisplayName("마지막 라운드에 도달하였지만 라운드를 진행시키면 예외가 발생한다.")
    void race_end_although_next_round() {
        String carNames = "ep,kim";
        StringToCars stringToCars = new StringToCars(carNames);
        Race race = new Race(stringToCars.toCars(), finalRound);
        assertThatThrownBy(() -> {
            for (int i = 0; i < finalRound + 1; i++) {
                race.nextRound();
            }
        }).isInstanceOf(RuntimeException.class);
    }
}
